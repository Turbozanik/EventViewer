package com.view.widgets

import android.content.Context
import android.text.Editable
import android.util.AttributeSet
import com.DEFAULT_INPUT_DEBOUNCE
import com.utils.DefaultTextWatcher
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class RxValidatableInputLayout : ValidatableInputLayout {

    private var updatesPublisher: PublishSubject<Boolean>? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs,
                                                                                  defStyleAttr) {
        init(attrs)
    }

    override fun initView() {
        super.initView()
        initUpdatesPublisher()
        editText?.post {
            initEditTextWatcher()
        }
    }

    private fun initUpdatesPublisher() {
        updatesPublisher = PublishSubject.create()
    }

    internal fun validate() {
        updatesPublisher?.onNext(isValid())
    }

    fun getValidityObservable(): Observable<Boolean>? {
        return updatesPublisher?.debounce(DEFAULT_INPUT_DEBOUNCE, TimeUnit.MILLISECONDS)
                ?.observeOn(AndroidSchedulers.mainThread())
    }

    private fun initEditTextWatcher() {
        editText?.addTextChangedListener(object : DefaultTextWatcher() {
            override fun afterTextChanged(editable: Editable) {
                updatesPublisher?.onNext(isValid())
            }
        })
    }

}