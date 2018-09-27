package com.view.ui.auth.login.configurator

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.ui.auth.login.LoginFragmentState

class LoginFragmentConfigurator : BaseFragmentConfigurator<LoginFragmentAction, LoginFragmentState, LoginFragmentViewCommand>() {

    override fun produceViewCommand(viewState: LoginFragmentState,
                                    action: LoginFragmentAction): LoginFragmentViewCommand {
        return when (action) {
            LoginFragmentAction.DEFAULT -> {
                handleActionType(action, viewState)
                LoginFragmentViewCommand.DEFAULT
            }
            LoginFragmentAction.LOGIN_CLICK -> {
                handleActionType(action, viewState)
                LoginFragmentViewCommand.LOGIN
            }
            LoginFragmentAction.LOGIN_WITH_SAVED_CREDENTIALS -> {
                handleActionType(action, viewState)
                LoginFragmentViewCommand.LOGIN_WITH_SAVED_CREDENTIALS
            }
            LoginFragmentAction.NOT_REGISTERED_CLICK -> {
                handleActionType(action, viewState)
                LoginFragmentViewCommand.GOT_TO_REGISTRATION
            }
        }
    }

    override fun handleActionType(action: LoginFragmentAction, viewState: LoginFragmentState) {
        if (action.mIsInitialState) {
            viewState.mInitialAction = action
            viewState.actionList.add(action)
        } else {
            viewState.actionList.add(action)
        }
    }

}
