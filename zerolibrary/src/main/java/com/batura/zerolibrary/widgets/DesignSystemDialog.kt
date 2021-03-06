package com.batura.zerolibrary.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.*
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes
import androidx.fragment.app.DialogFragment
import com.batura.zerolibrary.R
import kotlinx.android.synthetic.main.standard_container_dialog.*
import kotlinx.android.synthetic.main.standard_container_dialog.view.*
import kotlinx.android.synthetic.main.standard_dialog.*
import java.io.Serializable


class DesignSystemDialog(@LayoutRes val layoutDialog : Int, @StyleRes val dialogTheme : Int, val dismissEnabled : Boolean = true) : DialogFragment() {

    private var listener : DesignSystemDialogListener? = null
    fun setListener(listener: DesignSystemDialogListener){
        this.listener = listener
    }

    private var fragmentName  = ""

    private var dismissOnClickButton = false

    fun setDesignComponents(designSystemComponents: DesignSystemComponents) {
        val bundle = Bundle()
        bundle.putSerializable(DESIGN_SYSTEM_COMPONENTS_KEY,designSystemComponents)
        arguments = bundle

    }

    override fun onDestroyView() {
        super.onDestroyView()
        if(dismissOnClickButton.not()){
            dismiss?.invoke(fragmentName)
            listener?.onDismiss(fragmentName)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(layoutDialog,container,false)
        setBackground(view)
        return view;
    }

    private fun setBackground(view : View) {

        val contextWrapper = ContextThemeWrapper(context, dialogTheme)
        val typedValue = TypedValue()
        val theme = contextWrapper.theme
        theme.resolveAttribute(R.attr.dialog_background_color, typedValue, true)
        val drawable = ColorDrawable(typedValue.data)
        drawable.alpha = 140
        view.scd_main_container.background = drawable
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val serializable = arguments?.getSerializable(DESIGN_SYSTEM_COMPONENTS_KEY)

        if (serializable != null && serializable is DesignSystemComponents){
            processSystemComponents(serializable)
        }

        sd_left_button.setOnClickListener {

            dismissOnClickButton = true

            dismiss()

            leftClick?.invoke(fragmentName)

            listener?.onLeftButtonClick(fragmentName) }

        sd_right_button.setOnClickListener {

            dismissOnClickButton = true

            dismiss()
            rightClick?.invoke(fragmentName)

            listener?.onRightButtonClick(fragmentName) }


        if (dismissEnabled.not()){
            dialog?.setCanceledOnTouchOutside(false)
        }
        scd_main_container.setOnClickListener {
            if (dismissEnabled){
                dismiss()
            }
        }

        dialog?.setOnKeyListener { dialog, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_BACK && dismissEnabled) {
                dialog.dismiss()
            }
            true
        }
    }

    var rightClick : ((String) -> Unit)? = null

    var leftClick : ((String) -> Unit)? = null

    var dismiss : ((String) -> Unit)? = null



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext(), dialogTheme)

        dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY)

        return dialog
    }

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            if (listener == null)  listener = context as DesignSystemDialogListener

        } catch (ignore: ClassCastException) { }
    }

    private fun processSystemComponents(designSystemComponents: DesignSystemComponents){
        fragmentName = designSystemComponents.dialogName

        designSystemComponents.title?.let {
            sd_title.visibility = View.VISIBLE
            sd_title.text = it
        }

        designSystemComponents.description?.let {
            sd_description.visibility = View.VISIBLE
            sd_description.text = it
        }

        designSystemComponents.imageDrawable?.let {
            sd_image.visibility = View.VISIBLE
            sd_image.setImageResource(it)
        }

        designSystemComponents.leftButtonText?.let {
            sd_left_button.visibility = View.VISIBLE
            sd_left_button.text = it
        }

        designSystemComponents.rightButtonText?.let {
            sd_right_button.visibility = View.VISIBLE
            sd_right_button.text = it
        }

    }

    class DesignSystemComponents(val title: String? = null,
                                 val description : String? = null,
                                 val leftButtonText : String? = null,
                                 val rightButtonText :String? = null,
                                 @DrawableRes val imageDrawable : Int? = null,
                                 val dialogName : String = ""): Serializable

    interface DesignSystemDialogListener {
        fun onLeftButtonClick(dialogName : String){}
        fun onRightButtonClick(dialogName : String){}
        fun onDismiss(dialogName : String){}
    }

    companion object {
        const val DESIGN_SYSTEM_COMPONENTS_KEY  = "designComponentKey"
    }
}