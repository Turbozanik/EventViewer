package com.view.ui.auth.login

import com.domain.usecase.login.LoginUseCase
import com.view.ui.auth.login.configurator.LoginFragmentAction
import com.view.ui.auth.login.configurator.LoginFragmentConfigurator
import com.view.ui.auth.login.configurator.LoginFragmentViewCommand
import javax.inject.Inject


class LoginFragmentPresenter @Inject constructor() : LoginFragmentContract.LoginFragmentPresenter() {

    @Inject
    protected lateinit var mLoginUseCase: LoginUseCase

    private var loginFragmentData: LoginFragmentContract.LoginFragmentDto? = getView()?.getViewData()

    private val mLoginFragmentState: LoginFragmentState = LoginFragmentState()

    override fun intiConfigurator(): LoginFragmentConfigurator {
        return LoginFragmentConfigurator()
    }

    override fun consumeAction(action: LoginFragmentAction?) {
        if (action != null) {
            when (actionConfigurator.produceViewCommand(mLoginFragmentState, action)) {
                LoginFragmentViewCommand.LOGIN -> {
                    login()
                }
            }
        }
    }

    private fun login() {
        loginFragmentData = getView()?.getViewData()
        val body: Map<String, String> = HashMap()
        body.plus(Pair("email", loginFragmentData?.email))
        body.plus(Pair("password", loginFragmentData?.password))
        mLoginUseCase.buildFlowable(body)
    }

}