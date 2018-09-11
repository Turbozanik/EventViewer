package com.view.ui.auth.login.configurator

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.ui.auth.login.LoginFragmentState

class LoginFragmentConfigurator : BaseFragmentConfigurator<LoginFragmentState, LoginFragmentAction, LoginFragmentViewCommand>() {
    override fun produceViewCommand(viewState: LoginFragmentState,
                                    action: LoginFragmentAction): LoginFragmentViewCommand {
        when (action) {
            LoginFragmentAction.LOGIN -> {
                return LoginFragmentViewCommand.LOGIN
            }
        }
    }
}
