package com.view.base

import com.arellomobile.mvp.MvpPresenter
import com.utils.BgExecutors
import com.view.base.configurator.ActionConsumer
import com.view.base.configurator.BaseConfigurator
import com.view.base.view.BaseView
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


abstract class BasePresenter<ActionConfigurator : BaseConfigurator<*, *, *>, ConsumedActionType, ConsumedDataType, ViewType : BaseView> : ActionConsumer<ConsumedActionType, ConsumedDataType>, MvpPresenter<ViewType>() {

    private val mCompositeDisposable = CompositeDisposable()

    private val mConfigurator: ActionConfigurator? = null

    protected abstract fun intiConfigurator(): ActionConfigurator

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
            return mConfigurator ?: intiConfigurator()
        }

}
