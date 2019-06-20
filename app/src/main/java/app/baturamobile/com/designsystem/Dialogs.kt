package app.baturamobile.com.designsystem

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_dialogs.*
import kotlinx.android.synthetic.main.standard_dialog.*
import java.io.Serializable

class Dialogs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogs)

        ad_dialog_alert.setOnClickListener {
            val fragment = DesignSystemDialog(R.layout.standard_container_dialog,R.style.DialogsThemeBase)

            val test = DesignSystemDialog.DesignSystemComponents(
                description = "Alert dialog prompt, no more than two lines.",
                leftButtonText = "Button",
                rightButtonText = "Button")

            fragment.setDesignComponents(test)

            fragment.show(supportFragmentManager,"")

        }

        ad_dialog_head.setOnClickListener {
            val fragment = DesignSystemDialog(R.layout.standard_container_dialog,R.style.DialogsThemeBase)

            val test = DesignSystemDialog.DesignSystemComponents(
                title = "HeadLine 6",
                description = "Apparently we had reached a great height in the atmosphere, for the...",
                leftButtonText = "Button",
                rightButtonText = "Button")

            fragment.setDesignComponents(test)


            fragment.show(supportFragmentManager,"")
        }

        ad_dialog_head_img.setOnClickListener {
            val fragment = DesignSystemDialog(R.layout.standard_container_dialog,R.style.DialogsThemeBase)



            val test = DesignSystemDialog.DesignSystemComponents(
                title = "HeadLine 6",
                description = "Apparently we had reached a great height in the atmosphere, for the...",
                leftButtonText = "Button",
                rightButtonText = "Button",
                imageDrawable = R.drawable.avatar_40)

            fragment.setDesignComponents(test)

            fragment.show(supportFragmentManager,"")
        }

        ad_error.setOnClickListener {
            val fragment = DesignSystemDialog(R.layout.standard_container_dialog,R.style.DialogsThemeError,false)



            val test = DesignSystemDialog.DesignSystemComponents(
                description = "Alert dialog prompt, no more than two lines.",
                leftButtonText = "Button",
                rightButtonText = "Button")

            fragment.setDesignComponents(test)

            fragment.show(supportFragmentManager,"")
        }

        ad_default.setOnClickListener {
            val fragment = DesignSystemDialog(R.layout.standard_container_dialog,R.style.DialogsThemeBase)



            val test = DesignSystemDialog.DesignSystemComponents(
                description = "Alert dialog prompt, no more than two lines.",
                leftButtonText = "Button",
                rightButtonText = "Button")

            fragment.setDesignComponents(test)

            fragment.show(supportFragmentManager,"")
        }

        ad_success.setOnClickListener {
            val fragment = DesignSystemDialog(R.layout.standard_container_dialog,R.style.DialogsThemeSuccess)



            val test = DesignSystemDialog.DesignSystemComponents(
                description = "Alert dialog prompt, no more than two lines.",
                leftButtonText = "Button",
                rightButtonText = "Button")

            fragment.setDesignComponents(test)

            fragment.show(supportFragmentManager,"")
        }

        ad_alert.setOnClickListener {
            val fragment = DesignSystemDialog(R.layout.standard_container_dialog,R.style.DialogsThemeAlert)



            val test = DesignSystemDialog.DesignSystemComponents(
                description = "Alert dialog prompt, no more than two lines.",
                leftButtonText = "Button",
                rightButtonText = "Button")

            fragment.setDesignComponents(test)

            fragment.show(supportFragmentManager,"")
        }

        ad_primary.setOnClickListener {
            val fragment = DesignSystemDialog(R.layout.standard_container_dialog,R.style.DialogsThemePrimary)



            val test = DesignSystemDialog.DesignSystemComponents(
                description = "Alert dialog prompt, no more than two lines.",
                leftButtonText = "Button",
                rightButtonText = "Button")

            fragment.setDesignComponents(test)

            fragment.show(supportFragmentManager,"")
        }
    }

}

class DesignSystemDialog(@LayoutRes val layoutDialog : Int, @StyleRes val dialogTheme : Int,val dismissEnabled : Boolean = true) : DialogFragment() {

    private var listener : DesignSystemDialogListener? = null

    fun setDesignComponents(designSystemComponents: DesignSystemComponents) {
        val bundle = Bundle()
        bundle.putSerializable(DESIGN_SYSTEM_COMPONENTS_KEY,designSystemComponents)
        arguments = bundle

    }

    

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutDialog,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val serializable = arguments?.getSerializable(DESIGN_SYSTEM_COMPONENTS_KEY)

        if (serializable != null && serializable is DesignSystemComponents){
            processSystemComponents(serializable)
        }

        sd_left_button.setOnClickListener {
            dismiss()
            listener?.onLeftButtonClick() }

        sd_right_button.setOnClickListener {
            dismiss()
            listener?.onRightButtonClick() }

        scd_container.setOnClickListener {
            if (dismissEnabled){
                dismiss()
            }
        }
        dialog?.setOnKeyListener { dialog, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && dismissEnabled) {
                dialog.dismiss()
            }
            true
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext(), dialogTheme)

        dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY)
        
        return dialog
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = context as DesignSystemDialogListener
        } catch (ignore: ClassCastException) { }
    }

    private fun processSystemComponents(designSystemComponents: DesignSystemComponents){
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
            sd_right_button.text = it
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
                                 @DrawableRes val imageDrawable : Int? = null): Serializable

    interface DesignSystemDialogListener {
        fun onLeftButtonClick()
        fun onRightButtonClick()
    }

    companion object {
        const val DESIGN_SYSTEM_COMPONENTS_KEY  = "designComponentKey"

    }

}
