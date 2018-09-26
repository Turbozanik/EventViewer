package com.view.base.fragment

import android.content.Context
import android.os.Bundle
import com.view.base.presenter.BaseFragmentPresenter
import com.view.base.view.BaseView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class PresenterFragment<PresenterType : BaseFragmentPresenter<*, *, *>> : BaseFragment(), BaseView {

    private val compositeSubscription = CompositeDisposable()

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
        compositeSubscription.clear()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        addCurrentSubComponent()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onDetach() {
        super.onDetach()
        removeCurrentSubComponent()
    }

    protected fun addDisposable(disposable: Disposable) {
        compositeSubscription.add(disposable)
    }


    protected abstract val presenter: PresenterType

    protected abstract fun inject()

    protected abstract fun addCurrentSubComponent()

    protected abstract fun removeCurrentSubComponent()
}
