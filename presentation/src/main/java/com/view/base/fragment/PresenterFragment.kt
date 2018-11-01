package com.view.base.fragment

import com.view.base.view.BaseView
import com.view.ui.godlikeroot.RootGodlikeActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class PresenterFragment : MvpFragment(), BaseView {

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
