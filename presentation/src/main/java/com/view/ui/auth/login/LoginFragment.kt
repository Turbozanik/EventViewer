package com.view.ui.auth.login

import android.os.Bundle
import android.support.v4.app.Fragment
import com.Constants
import com.view.R
import com.view.base.fragment.PresenterFragment
import com.view.ui.auth.login.configurator.LoginFragmentAction
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class LoginFragment : PresenterFragment<LoginFragmentContract.LoginFragmentPresenter>() {

    @Inject
    lateinit var mPresenter: LoginFragmentPresenter

    companion object {
        fun createNewInstance(): LoginFragment {
            return LoginFragment()
        }

        fun addInitialAction(fragment: Fragment, initialAction: LoginFragmentAction) {
            val args = Bundle()
            args.putSerializable(Constants.FRAGMENT_DATA_KEY, initialAction)
            fragment.arguments = args
        }
    }

    override fun inject() {
        daggerController.loginFragmentSubComponent?.inject(this)
    }

    override fun addCurrentSubComponent() {
        daggerController.addLoginFragmentSubComponent()
    }

    override fun removeCurrentSubComponent() {
        daggerController.removeLoginFragmentSubComponent()
    }

    override val layoutId: Int
        get() = R.layout.fragment_login

    override fun initView() {
    }

    override val presenter: LoginFragmentPresenter
        get() {
            return mPresenter
        }

}
