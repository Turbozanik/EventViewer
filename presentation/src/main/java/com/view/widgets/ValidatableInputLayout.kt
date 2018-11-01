package com.view.widgets

import android.content.Context
import android.content.res.TypedArray
import android.support.design.widget.TextInputLayout
import android.util.AttributeSet
import com.utils.ValidationUtils
import com.view.R


open class ValidatableInputLayout : TextInputLayout {

    private lateinit var mAttrs: AttributeSet
    private lateinit var ta: TypedArray
    private var validationType: Int = 0
    private var errorStringResId: Int = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs,
            defStyleAttr) {
        init(attrs)
    }


    protected open fun initView() {
        validationType = ta.getInt(R.styleable.ValidatableInputLayout_validationType, 0)
        errorStringResId = ta.getResourceId(R.styleable.ValidatableInputLayout_errorStringRes, 0)
    }

    protected fun init(attrs: AttributeSet) {
        mAttrs = attrs
        try {
            ta = context.obtainStyledAttributes(mAttrs, R.styleable.ValidatableInputLayout, 0, 0)
            initView()
        } finally {
            ta.recycle()
        }
    }

    //<enum name="NONE" value="0" />
//<enum name="EMAIL" value="1" />
//<enum name="PASSWORD" value="2" />
//<enum name="USER_NAME" value="3" />
//<enum name="SURE_NAME" value="4" />
    fun isValid(): Boolean {
        return when (validationType) {
            0 -> true
            1 -> validateEmail()
            2 -> validatePassword()
            3 -> true
            4 -> true
            else -> {
                true
            }
        }
    }

    protected fun validateEmail(): Boolean {
        val isValid = ValidationUtils.validateEmail(editText?.text.toString())
        error = if (errorStringResId != 0 && !isValid) context.getString(errorStringResId) else null
        return isValid
    }

    protected fun validatePassword(): Boolean {
        val isValid = ValidationUtils.validatePassword(editText?.text.toString())
        error = if (errorStringResId != 0 && !isValid) context.getString(errorStringResId) else null
        return isValid
    }

}