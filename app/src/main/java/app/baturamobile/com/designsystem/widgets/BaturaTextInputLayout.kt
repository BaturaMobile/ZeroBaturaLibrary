package app.baturamobile.com.designsystem.widgets

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.util.Log
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.google.android.material.R
import com.google.android.material.internal.ThemeEnforcement
import com.google.android.material.resources.MaterialResources
import com.google.android.material.textfield.TextInputLayout

class BaturaTextInputLayout : TextInputLayout{

    constructor(context : Context) : super(context)

    constructor(context : Context, attrs: AttributeSet, defStyleAttr : Int) : super(context,attrs,defStyleAttr)

    private var stateFocusedHelperTextColor : Int = -1
    private var defaultHelperTextColor : Int = -1

    @SuppressLint("RestrictedApi", "PrivateResource")
    constructor(context : Context, attrs: AttributeSet) : super(context,attrs){

        val a = ThemeEnforcement.obtainTintedStyledAttributes(
            context,
            attrs,
            R.styleable.TextInputLayout,
            R.attr.textInputStyle,
            R.style.Widget_Design_TextInputLayout,
            R.styleable.TextInputLayout_counterTextAppearance,
            R.styleable.TextInputLayout_counterOverflowTextAppearance,
            R.styleable.TextInputLayout_errorTextAppearance,
            R.styleable.TextInputLayout_helperTextTextAppearance,
            R.styleable.TextInputLayout_hintTextAppearance
        )

        val helperTextColorStateList = MaterialResources.getColorStateList(
            context, a, R.styleable.TextInputLayout_helperTextTextColor)

        helperTextColorStateList?.let {
            stateFocusedHelperTextColor = it.getColorForState(
                intArrayOf(android.R.attr.state_focused), -1
            )
            defaultHelperTextColor = it.defaultColor
        }

    }

    override fun drawableStateChanged()
    {
        super.drawableStateChanged()

        val hasFocus = isFocused || editText != null && editText!!.hasFocus()

        val helperTextColor =  helperText?.let {
            if (hasFocus){
                stateFocusedHelperTextColor
            }else{
                defaultHelperTextColor
            }
        }

        helperTextColor?.let {
            setHelperTextColor(ColorStateList.valueOf(it))
        }

    }


}