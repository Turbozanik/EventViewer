package com.view.ui.register

import android.os.Bundle
import android.support.v4.app.Fragment
import com.Constants
import com.view.R
import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.base.presenter.BaseFragmentPresenter
import com.view.ui.register.configurator.RegistrationFragmentAction
import javax.inject.Inject


class RegistrationFragment : PresenterFragment(), ActionProducer<RegistrationFragmentAction> {

    companion object {
        fun createNewInstance(): RegistrationFragment {
            return RegistrationFragment()
        }

        fun addInitialAction(fragment: Fragment, initialAction: RegistrationFragmentAction) {
            val args = Bundle()
            args.putSerializable(Constants.FRAGMENT_DATA_KEY, initialAction)
            fragment.arguments = args
        }
    }

    @Inject
    lateinit var mPresenter: RegistrationFragmentPresenter

    override fun inject() {
        mDaggerController.getRegistrationFragmentSubComponent()?.inject(this)
    }

    override fun addCurrentSubComponent() {
        mDaggerController.addRegistrationFragmentSubComponent()
    }

    override fun removeCurrentSubComponent() {
        mDaggerController.removeRegistrationFragmentSubComponent()
    }

    override val layoutId: Int
        get() = R.layout.fragment_ragistration

    override fun initView() {
    }

    override fun getPresenter(): BaseFragmentPresenter<*, *, *> {
        return mPresenter
    }

    override fun sendAction(action: RegistrationFragmentAction?) {
        mPresenter.consumeAction(action)
    }

}