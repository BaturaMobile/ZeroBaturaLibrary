package com.baturamobile.mvp.v4

import android.app.Activity
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater

import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import java.lang.ref.WeakReference


abstract class BaseActivityV4 : AppCompatActivity() {

    abstract val activityDelegate: ActivityDelegateV4?

    override fun onCreate(savedInstanceState: Bundle?) {
        activityDelegate?.injectLifeCycle(lifecycle)
        super.onCreate(savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item != null && item.itemId == android.R.id.home) {
            checkFinishMethod()
            true
        } else {
            super.onOptionsItemSelected(item)
        }

    }


    override fun onBackPressed() {
        checkFinishMethod()
    }

    private fun checkFinishMethod() {
        val upIntent = NavUtils.getParentActivityIntent(this)
        if (upIntent != null) {
            if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                // This activity is NOT part of this app's task, so create a new task
                // when navigating up, with a synthesized back stack.
                TaskStackBuilder.create(this)
                        // Add all of this activity's parents to the back stack
                        .addNextIntentWithParentStack(upIntent)
                        // Navigate up to the closest parent
                        .startActivities()
            } else {
                // This activity is part of this app's task, so simply
                // navigate up to the logical parent activity.
                NavUtils.navigateUpTo(this, upIntent)
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                finishAfterTransition()
            } else {
                finish()
            }
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        if (activityDelegate != null) {
            super.attachBaseContext(activityDelegate!!.attachBaseContext(newBase!!))
        } else {
            super.attachBaseContext(newBase)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        activityDelegate?.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        activityDelegate?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

}

abstract class BaseFragmentV4 : Fragment() {

    abstract val fragmentDelegate: FragmentDelegateV4?

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        fragmentDelegate?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        fragmentDelegate?.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}

abstract class BaseDialogFragmentV4 : DialogFragment() {

    abstract val fragmentDelegate: FragmentDelegateV4?

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        fragmentDelegate?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        fragmentDelegate?.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}

abstract class MVPDialogFragmentV4<out T : BasePresenterV4<out BaseContractV4>> : BaseDialogFragmentV4(), BaseContractV4 {


    abstract fun injectDI()

    abstract val presenter: T?

    abstract var fragmentView: Int

    override fun onSuccess(typeSuccess: Any?) {
        viewDelegate?.onSuccess(typeSuccess, viewDelegateButtonCallback)
    }

    override fun getSupportActivity(): AppCompatActivity? {
        return activity as AppCompatActivity?
    }

    open fun setupViews() {}

    override fun finish() {
        activity?.finish()
    }


    abstract val viewDelegate: ViewDelegateV4?

    override fun onError(error: String?, type: ViewDelegateV4.Type, throwable: Throwable?, keyError: String) {
        var stringError: String? = null
        if (error != null && error.isNotBlank()) {
            stringError = error
        } else if (throwable != null) {
            stringError = throwable.message
        }
        viewDelegate?.launchError(stringError, throwable, type, keyError, viewDelegateButtonCallback)
    }

    private val viewDelegateButtonCallback = object : ViewDelegateV4.ButtonCallback {
        override fun buttonPressed(type: ViewDelegateV4.Type, key: String) {
            onViewDelegateButtonClicked(type, key)
        }
    }


    override fun loading(loading: Boolean) {
        viewDelegate?.loading(loading)
    }

    override fun getBundle(): Bundle? {
        activity?.let {
            if (activity is MVPActivityV4<*>) {
                return (activity as MVPActivityV4<*>).getBundle()
            }
        }
        return null
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        fragmentDelegate?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        fragmentDelegate?.onActivityResult(requestCode, resultCode, data)
        presenter?.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter?.onActivityCreated(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDI()
        presenter?.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        presenter?.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenter?.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        presenter?.onLowMemory()
    }

    override fun onDetach() {
        super.onDetach()
        presenter?.onDetach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter?.onDestroyView()
    }


    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fragmentDelegate?.injectLifeCycle(lifecycle)
        super.onViewCreated(view, savedInstanceState)
        presenter?.injectLifeCycle(lifecycle)

        setupViews()

        presenter?.onViewCreated()
        presenter?.onViewReady()

        fragmentDelegate?.injectLifeCycle(lifecycle)
        viewDelegate?.injectLifeCycle(lifecycle)
        if (view is ViewGroup) {
            viewDelegate?.currentMainContainerSet(view)
        }

    }

    open fun onViewDelegateButtonClicked(type: ViewDelegateV4.Type, keyError: String) {
        presenter?.onViewDelegateButtonClicked(type, keyError)
    }
}

abstract class MVPFragmentV4<out T : BasePresenterV4<out BaseContractV4>> : com.baturamobile.mvp.v4.BaseFragmentV4(), BaseContractV4 {


    abstract fun injectDI()

    abstract val presenter: T?

    abstract var fragmentView: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(fragmentView, container, false)
    }

    override fun onSuccess(typeSuccess: Any?) {
        viewDelegate?.onSuccess(typeSuccess, viewDelegateButtonCallback)
    }

    override fun getSupportActivity(): AppCompatActivity? {
        return activity as AppCompatActivity?
    }

    open fun setupViews() {}

    override fun finish() {
        activity?.finish()
    }


    abstract val viewDelegate: ViewDelegateV4?

    override fun onError(error: String?, type: ViewDelegateV4.Type, throwable: Throwable?, keyError: String) {
        var stringError: String? = null
        if (error != null && error.isNotBlank()) {
            stringError = error
        } else if (throwable != null) {
            stringError = throwable.message
        }
        viewDelegate?.launchError(stringError, throwable, type, keyError, viewDelegateButtonCallback)
    }

    private val viewDelegateButtonCallback = object : ViewDelegateV4.ButtonCallback {
        override fun buttonPressed(type: ViewDelegateV4.Type, key: String) {
            onViewDelegateButtonClicked(type, key)
        }
    }


    override fun loading(loading: Boolean) {
        viewDelegate?.loading(loading)
    }

    override fun getBundle(): Bundle? {
        activity?.let {
            if (activity is MVPActivityV4<*>) {
                return (activity as MVPActivityV4<*>).getBundle()
            }
        }
        return null
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        fragmentDelegate?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        fragmentDelegate?.onActivityResult(requestCode, resultCode, data)
        presenter?.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter?.onActivityCreated(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDI()
        presenter?.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        presenter?.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenter?.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        presenter?.onLowMemory()
    }

    override fun onDetach() {
        super.onDetach()
        presenter?.onDetach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter?.onDestroyView()
    }


    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fragmentDelegate?.injectLifeCycle(lifecycle)
        super.onViewCreated(view, savedInstanceState)
        presenter?.injectLifeCycle(lifecycle)

        fragmentDelegate?.injectLifeCycle(lifecycle)
        viewDelegate?.injectLifeCycle(lifecycle)
        if (view is ViewGroup) {
            viewDelegate?.currentMainContainerSet(view)
        }
        setupViews()
        presenter?.onViewCreated()
        presenter?.onViewReady()
    }

    open fun onViewDelegateButtonClicked(type: ViewDelegateV4.Type, keyError: String) {
        presenter?.onViewDelegateButtonClicked(type, keyError)
    }
}

abstract class MVPActivityV4<out T : BasePresenterV4<out BaseContractV4>> : com.baturamobile.mvp.v4.BaseActivityV4(), BaseContractV4 {
    override fun getContext(): Context {
        return this
    }

    abstract fun injectDI()

    abstract val presenter: T?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityView)
        if (intent.extras != null) {
            dataBundle = intent.extras
        } else if (savedInstanceState != null) {
            dataBundle = savedInstanceState
        }

        injectDI()
        presenter?.injectLifeCycle(lifecycle)
        viewDelegate?.injectLifeCycle(lifecycle)
        presenter?.onCreate(savedInstanceState)
    }


    abstract val viewDelegate: ViewDelegateV4?


    open fun setupViews() {}

    override fun getSupportActivity(): AppCompatActivity? {
        return this
    }

    override fun setContentView(@LayoutRes layoutResID: Int) {
        super.setContentView(layoutResID)
        setupViews()
        viewDelegate?.currentMainContainerSet(findViewById(android.R.id.content))
        presenter?.onViewReady()
    }

    abstract var activityView: Int


    private var dataBundle: Bundle? = null

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        dataBundle?.putAll(dataBundle)
        presenter?.onSaveInstanceState(outState)
    }


    override fun getBundle(): Bundle? {
        return if (dataBundle != null) {
            dataBundle
        } else {
            intent.extras
        }
    }


    override fun getArguments(): Bundle? {
        return if (dataBundle != null) {
            dataBundle
        } else {
            intent.extras
        }
    }

    override fun onStart() {
        super.onStart()
        presenter?.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenter?.onStop()
    }

    override fun loading(loading: Boolean) {
        viewDelegate?.loading(loading)
    }

    override fun onError(error: String?, type: ViewDelegateV4.Type, throwable: Throwable?, keyError: String) {
        var stringError: String? = null
        if (error != null && error.isNotEmpty()) {
            stringError = error
        } else if (throwable != null) {
            stringError = throwable.message
        }
        viewDelegate?.launchError(stringError, throwable, type, keyError, viewDelegateButtonCallback)
    }

    private val viewDelegateButtonCallback = object : ViewDelegateV4.ButtonCallback {
        override fun buttonPressed(type: ViewDelegateV4.Type, key: String) {
            onErrorButtonClicked(type, key)
        }
    }

    open fun onErrorButtonClicked(type: ViewDelegateV4.Type, keyError: String) {
        presenter?.onViewDelegateButtonClicked(type, keyError)
    }

    override fun onSuccess(typeSuccess: Any?) {
        viewDelegate?.onSuccess(typeSuccess, viewDelegateButtonCallback)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        presenter?.onActivityResult(requestCode, resultCode, data)
        activityDelegate?.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

}

abstract class BasePresenterV4<T : BaseContractV4>(contract: T) : LifecycleObserver {

     val SUCESS_ACTIVITY_RESULT = 1235

    var viewInterface: WeakReference<T>? = null

    init {
        this.viewInterface = WeakReference(contract)
    }

    abstract fun onViewReady()

    private var lifeCycle: Lifecycle? = null

    fun injectLifeCycle(lifeCycle: Lifecycle) {
        this.lifeCycle = lifeCycle
        this.lifeCycle!!.addObserver(this)
    }


    open fun onCreate(savedInstanceState: Bundle?) {}

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {
        lifeCycle?.removeObserver(this)
        viewInterface = null
    }

    open fun onStart() {}

    open fun onStop() {}

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun onPause() {
    }


    fun getViewContract(): T? {
        return viewInterface?.get()
    }

    fun inject(contract: T) {
        viewInterface = WeakReference(contract)
    }


    @CallSuper
    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SUCESS_ACTIVITY_RESULT && resultCode == Activity.RESULT_OK) {
            getViewContract()?.finish()
        }
    }

    open fun onAttach(context: Context?) {}
    open fun onLowMemory() {}
    open fun onActivityCreated(savedInstanceState: Bundle?) {}
    open fun onDetach() {}
    open fun onDestroyView() {}
    open fun onSaveInstanceState(outState: Bundle?) {}
    open fun onViewCreated() {}

    abstract fun onViewDelegateButtonClicked(type: ViewDelegateV4.Type, keyError: String)


}


interface BaseContractV4 {
    fun onSuccess(typeSuccess: Any? = null)

    fun getContext(): Context?

    fun getSupportActivity(): AppCompatActivity?

    fun loading(loading: Boolean)

    fun onError(error: String?, type: ViewDelegateV4.Type, throwable: Throwable?, keyError: String = "")

    fun finish()

    fun getBundle(): Bundle?

    fun getArguments(): Bundle?
}

abstract class ViewDelegateV4(val activity: WeakReference<Activity>) : LifecycleObserver {

    enum class Type { RETRY, OK }

    interface ButtonCallback {
        fun buttonPressed(type: Type, key: String)
    }

    abstract fun launchError(stringError: String?, exception: Throwable?, type: Type, keyError: String,
                             buttonCallback: ButtonCallback)

    var mainContainer: View? = null
        private set

    abstract fun loading(loading: Boolean)
    @CallSuper
    open fun currentMainContainerSet(view: View?) {
        mainContainer = view
    }

    abstract fun onSuccess(typeSuccess: Any?, buttonCallback: ButtonCallback? = null)

    private var lifeCycle: Lifecycle? = null

    fun injectLifeCycle(lifecycle: Lifecycle) {
        this.lifeCycle = lifecycle
        this.lifeCycle!!.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {
        lifeCycle?.removeObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun onPause() {
    }

}

abstract class ActivityDelegateV4(val activity: WeakReference<Activity>) : LifecycleObserver {

    private var lifeCycle: Lifecycle? = null

    fun injectLifeCycle(lifecycle: Lifecycle) {
        this.lifeCycle = lifecycle
        this.lifeCycle!!.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {
        lifeCycle?.removeObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun onPause() {
    }

    open fun attachBaseContext(newBase: Context): Context {
        return newBase
    }

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {}
    open fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {}
}

abstract class FragmentDelegateV4(val fragment: WeakReference<Activity>) : LifecycleObserver {

    private var lifeCycle: Lifecycle? = null

    fun injectLifeCycle(lifecycle: Lifecycle) {
        this.lifeCycle = lifecycle
        this.lifeCycle!!.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {
        lifeCycle?.removeObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun onPause() {
    }

    open fun attachBaseContext(newBase: Context): Context {
        return newBase
    }

    open fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {}
    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {}
}