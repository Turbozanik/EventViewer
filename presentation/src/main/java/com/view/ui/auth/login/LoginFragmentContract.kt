package com.view.ui.auth.login

import com.view.base.presenter.BaseFragmentPresenter
import com.view.base.presenter.BasePresenterContract
import com.view.base.view.BaseView
import com.view.ui.auth.login.configurator.LoginFragmentAction
import com.view.ui.auth.login.configurator.LoginFragmentConfigurator


interface LoginFragmentContract : BasePresenterContract {

    data class UserCredentials(val email: String?, val password: String?)

    data class LoginFragmentDto(val userCredentials: UserCredentials)

    interface LoginFragmentView : BaseView {

        fun getViewData(): LoginFragmentDto

    }

    abstract class LoginFragmentPresenter : BaseFragmentPresenter<LoginFragmentConfigurator, LoginFragmentAction, LoginFragmentContract.LoginFragmentView>()
}