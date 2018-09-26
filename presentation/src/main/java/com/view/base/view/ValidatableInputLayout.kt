package com.view.base.view

import android.content.Context
import android.content.res.TypedArray
import android.support.design.widget.TextInputLayout
import android.text.Editable
import android.util.AttributeSet
import com.DEFAULT_INPUT_DEBOUNCE
import com.utils.DefaultTextWatcher
import com.utils.ValidationUtils
import com.view.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class ValidatableInputLayout : TextInputLayout {

    private lateinit var mAttrs: AttributeSet
    private lateinit var ta: TypedArray
    private var validationType: Int = 0
    private var errorStringResId: Int = 0
    private var updatesPublisher: PublishSubject<Boolean>? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs,
            defStyleAttr) {
        init(attrs)
    }


    private fun initView() {
        validationType = ta.getInt(R.styleable.ValidatableInputLayout_validationType, 0)
        errorStringResId = ta.getResourceId(R.styleable.ValidatableInputLayout_errorStringRes, 0)
        initUpdatesPublisher()
        post {
            initEditTextWatcher()
        }
    }

    private fun init(attrs: AttributeSet) {
        mAttrs = attrs
        try {
            ta = context.obtainStyledAttributes(mAttrs, R.styleable.ValidatableInputLayout, 0, 0)
            initView()
        } finally {
            ta.recycle()
        }
    }

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

    private fun validateEmail(): Boolean {
        val isValid = ValidationUtils.validateEmail(editText?.text.toString())
        error = if (errorStringResId != 0 && !isValid) context.getString(errorStringResId) else null
        return isValid
    }

    private fun validatePassword(): Boolean {
        val isValid = ValidationUtils.validatePassword(editText?.text.toString())
        error = if (errorStringResId != 0 && !isValid) context.getString(errorStringResId) else null
        return isValid
    }


    private fun initUpdatesPublisher() {
        updatesPublisher = PublishSubject.create()
        updatesPublisher?.debounce(DEFAULT_INPUT_DEBOUNCE, TimeUnit.MILLISECONDS)
                ?.observeOn(AndroidSchedulers.mainThread())
    }

    private fun initEditTextWatcher() {
        editText?.addTextChangedListener(object : DefaultTextWatcher() {
            override fun afterTextChanged(editable: Editable) {
                updatesPublisher?.onNext(isValid())
            }
        })
    }

    internal fun validate() {
        updatesPublisher?.onNext(isValid())
    }

    fun getValidityObservable(): PublishSubject<Boolean>? {
        return updatesPublisher
    }


}