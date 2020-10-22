package com.batura.zerolibrary.widgets

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.FrameLayout
import com.batura.zerolibrary.R
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.empty_state_layout.view.*
import kotlinx.android.synthetic.main.material_banner.view.*

class EmptyState : FrameLayout {

    private var _buttonText: String? = "Please fill me in" // TODO: use a default from R.string...
    private var _emptyTitleText: String? = "Dismiss" // TODO: use a default from R.string...
    private var _emptyDescriptionText: String? = "Right Button" // TODO: use a default from R.string...
    private var _image: Drawable? = null // invisible by default



    /**
     * The text to draw
     */
    var buttonText: String?
        get() = _buttonText
        set(value) {
            _buttonText = value
            esl_button.text = value
        }

    var emptyTitleText: String?
        get() = _emptyTitleText
        set(value) {
            _emptyTitleText = value
            esl_description.text = value
        }

    var emptyDescriptionText: String?
        get() = _emptyDescriptionText
        set(value) {
            _emptyDescriptionText = value
            esl_title.text = value
        }

    var image: Drawable?
        get() = _image
        set(value) {
            if (value == null){
                esl_image.visibility = View.GONE
            }else{
                _image = value
                esl_image.setImageDrawable(value)
                esl_image.visibility = View.VISIBLE
            }

        }

    fun getButton() : MaterialButton{
        return esl_button
    }


    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        // Load attributes
        View.inflate(context, R.layout.empty_state_layout, this)

        val typedArray = context.obtainStyledAttributes(
            attrs, R.styleable.EmptyState, defStyle, 0
        )

        buttonText = typedArray.getString(
            R.styleable.EmptyState_emptyButtonText
        )

        emptyTitleText = typedArray.getString(
            R.styleable.EmptyState_emptyTitleText
        )

        emptyDescriptionText = typedArray.getString(
            R.styleable.EmptyState_emptyDescriptionText
        )

        image = typedArray.getDrawable(
            R.styleable.EmptyState_emptyImage
        )


        typedArray.recycle()

    }



}
