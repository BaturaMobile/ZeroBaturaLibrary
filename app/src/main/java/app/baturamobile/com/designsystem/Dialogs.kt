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
import app.baturamobile.com.designsystem.widgets.DesignSystemDialog
import kotlinx.android.synthetic.main.activity_dialogs.*
import kotlinx.android.synthetic.main.standard_dialog.*
import java.io.Serializable

class Dialogs : AppCompatActivity(), DesignSystemDialog.DesignSystemDialogListener {
    override fun onRightButtonClick(dialogName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLeftButtonClick(dialogName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogs)

        ad_dialog_alert.setOnClickListener {
            val fragment = DesignSystemDialog(R.layout.standard_container_dialog,R.style.DialogsThemeBase)

            val test = DesignSystemDialog.DesignSystemComponents(
                description = "Alert dialog prompt, no more than two lines.",
                leftButtonText = "Button",
                rightButtonText = "Button")
            //TODO make dialogs compatible with one button and name dialog

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

        /* Over this don´t use in production (Not ready in version 1.0 of design system) */

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


