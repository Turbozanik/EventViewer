package com.view.ui.modules.auth.login.configurator

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.ui.modules.auth.login.LoginFragmentState

class LoginFragmentConfigurator : BaseFragmentConfigurator<LoginFragmentAction, LoginFragmentState, LoginFragmentViewCommand>() {

    override fun produceViewCommand(viewState: LoginFragmentState,
                                    action: LoginFragmentAction): LoginFragmentViewCommand {
        saveAction(action, viewState)
        return when (action) {
            LoginFragmentAction.DEFAULT -> {
                LoginFragmentViewCommand.DEFAULT
            }
            LoginFragmentAction.LOGIN_CLICK -> {
                LoginFragmentViewCommand.LOGIN
            }
            LoginFragmentAction.LOGIN_WITH_SAVED_CREDENTIALS -> {
                LoginFragmentViewCommand.LOGIN_WITH_SAVED_CREDENTIALS
            }
            LoginFragmentAction.NOT_REGISTERED_CLICK -> {
                LoginFragmentViewCommand.GOT_TO_REGISTRATION
            }
        }
    }

    override fun saveAction(action: LoginFragmentAction, viewState: LoginFragmentState) {
        if (action.mIsInitialState) {
            viewState.mInitialAction = action
            viewState.actionList.add(action)
        } else {
            viewState.actionList.add(action)
        }
    }

}
