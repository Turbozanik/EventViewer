package com.view.ui.auth.login.configurator

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.ui.auth.login.LoginFragmentState

class LoginFragmentConfigurator : BaseFragmentConfigurator<LoginFragmentState, LoginFragmentAction, LoginFragmentViewCommand>() {
    override fun produceViewCommand(viewState: LoginFragmentState,
                                    action: LoginFragmentAction): LoginFragmentViewCommand {
        return when (action) {
            LoginFragmentAction.DEFAULT -> {
                LoginFragmentViewCommand.DEFAULT
            }
            LoginFragmentAction.LOGIN -> {
                LoginFragmentViewCommand.LOGIN
            }
            LoginFragmentAction.LOGIN_WITH_SAVED_CREDENTIALS -> {
                LoginFragmentViewCommand.LOGIN_SAVED_CREDENTIALS
            }
        }
    }
}
