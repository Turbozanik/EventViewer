package com.view.base.fragment

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.view.base.view.BaseView
import com.view.ui.godlikeroot.RootGodlikeActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class PresenterFragment<ViewType : BaseView, PresenterType : MvpPresenter<ViewType>> : BaseMvpFragment<ViewType, PresenterType>(), BaseView {

    private val compositeSubscription = CompositeDisposable()

    override fun onDestroyView() {
        super.onDestroyView()
        compositeSubscription.clear()
    }

    protected fun addDisposable(disposable: Disposable) {
        compositeSubscription.add(disposable)
    }

    override fun showProgress() {
        (activity as RootGodlikeActivity).showProgress()
    }

    override fun hideProgress() {
        (activity as RootGodlikeActivity).hideProgress()
    }
}
