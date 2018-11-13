package com.view.ui.modules.auth.login

import com.view.base.BasePresenter
import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.base.fragment.presenter.BasePresenterContract
import com.view.ui.modules.auth.login.configurator.LoginFragmentAction
import com.view.ui.modules.auth.login.configurator.LoginFragmentConfigurator


interface LoginFragmentContract : BasePresenterContract {

    data class UserCredentials(val email: String, val password: String)

    data class LoginFragmentDto(var userCredentials: UserCredentials,
                                val shouldSaveCredentials: Boolean)

    abstract class LoginPresenter : BasePresenter<LoginFragmentConfigurator, LoginFragmentAction, LoginFragmentDto, LoginFragmentView>() {
        init {
            this.intiConfigurator()
            this.injectPresenter()
        }
    }

    abstract class LoginFragment : PresenterFragment(), LoginFragmentView, ActionProducer<LoginFragmentAction, LoginFragmentDto>

}