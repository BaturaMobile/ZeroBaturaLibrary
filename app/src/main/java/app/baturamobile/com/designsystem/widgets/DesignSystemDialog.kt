package app.baturamobile.com.designsystem.widgets

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.standard_container_dialog.*
import kotlinx.android.synthetic.main.standard_dialog.*
import java.io.Serializable

class DesignSystemDialog(@LayoutRes val layoutDialog : Int, @StyleRes val dialogTheme : Int, val dismissEnabled : Boolean = true) : DialogFragment() {

    private var listener : DesignSystemDialogListener? = null

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
              listener?.onDismiss(fragmentName)
        }
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

            dismissOnClickButton = true

            dismiss()
            listener?.onLeftButtonClick(fragmentName) }

        sd_right_button.setOnClickListener {

            dismissOnClickButton = true

            dismiss()
            listener?.onRightButtonClick(fragmentName) }


        if (dismissEnabled.not()){
            dialog?.setCanceledOnTouchOutside(false)
        }
        scd_main_container.setOnClickListener {
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
        fun onLeftButtonClick(dialogName : String)
        fun onRightButtonClick(dialogName : String)
        fun onDismiss(dialogName : String)
    }

    companion object {
        const val DESIGN_SYSTEM_COMPONENTS_KEY  = "designComponentKey"

    }

}