package com.view.ui.auth.login

import com.view.base.presenter.BaseFragmentPresenter
import com.view.base.presenter.BasePresenterContract
import com.view.base.view.BaseView
import com.view.ui.auth.login.configurator.LoginFragmentAction
import com.view.ui.auth.login.configurator.LoginFragmentConfigurator


interface LoginFragmentContract : BasePresenterContract {

    data class LoginFragmentDto(val email: String, val password: String)

    interface LoginFragmentView : BaseView {

        fun login()

        fun getViewData(): LoginFragmentDto

    }

    abstract class LoginFragmentPresenter : BaseFragmentPresenter<LoginFragmentConfigurator, LoginFragmentAction, LoginFragmentContract.LoginFragmentView>()
}