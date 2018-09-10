package com.view.ui.auth.login

import com.domain.usecase.login.LoginUseCase
import com.view.ui.auth.login.configurator.LoginFragmentAction
import com.view.ui.auth.login.configurator.LoginFragmentConfigurator
import javax.inject.Inject


class LoginFragmentPresenter @Inject constructor() : LoginFragmentContract.LoginFragmentPresenter(), LoginFragmentContract.LoginFragmentView {

    @Inject
    protected lateinit var mLoginUseCase: LoginUseCase

    private val mLoginFragmentState: LoginFragmentState = LoginFragmentState()

    override fun intiConfigurator(): LoginFragmentConfigurator {
        return LoginFragmentConfigurator()
    }

    override fun consumeAction(action: LoginFragmentAction?) {
        if (action != null) {
            when (actionConfigurator.produceViewCommand(mLoginFragmentState, action)) {

            }
        }
    }

    override fun login(email: String, password: String) {
        val body: Map<String, String> = HashMap()
        body.plus(Pair("email", email))
        body.plus(Pair("password", password))
        mLoginUseCase.buildFlowable(body)
    }
}