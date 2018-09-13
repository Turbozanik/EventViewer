package com.view.base.presenter

import com.utils.BgExecutors
import com.view.base.configurator.ActionConsumer
import com.view.base.configurator.BaseFragmentConfigurator
import com.view.base.view.BaseView
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class BaseFragmentPresenter<ActionConfigurator : BaseFragmentConfigurator<*, *, *>, ConsumedActionType, ViewType : BaseView> : ActionConsumer<ConsumedActionType> {

    private val mCompositeDisposable = CompositeDisposable()
    protected var mView: ViewType? = null

    private val mConfigurator: ActionConfigurator? = null

    protected abstract fun intiConfigurator(): ActionConfigurator

    fun attachView(view: ViewType) {
        mView = view
    }

    fun getView(): ViewType? = mView

    fun detachView() {
        mCompositeDisposable.clear()
        mView = null
    }

    protected fun addDisposable(disposable: Disposable) {
        mCompositeDisposable.add(disposable)
    }

    protected fun <T> inBackground(dest: Flowable<T>): Flowable<T> {
        return dest.subscribeOn(Schedulers.from(BgExecutors.Executor))
                .observeOn(AndroidSchedulers.mainThread())
    }

    protected fun <T> inBackground(dest: Observable<T>): Observable<T> {
        return dest.subscribeOn(Schedulers.from(BgExecutors.Executor))
                .observeOn(AndroidSchedulers.mainThread())
    }

    protected fun inBackground(runnable: Runnable) {
        BgExecutors.Executor.submit(runnable)
    }

    protected val actionConfigurator: ActionConfigurator
        get() {
            return mConfigurator!!
        }

}