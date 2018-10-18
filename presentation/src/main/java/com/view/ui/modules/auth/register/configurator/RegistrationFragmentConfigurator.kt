package com.view.ui.modules.auth.register.configurator

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.ui.modules.auth.register.RegistrationFragmentState

class RegistrationFragmentConfigurator : BaseFragmentConfigurator<RegistrationFragmentAction, RegistrationFragmentState, RegistrationFragmentViewCommand>() {

    override fun produceViewCommand(viewState: RegistrationFragmentState,
                                    action: RegistrationFragmentAction): RegistrationFragmentViewCommand {
        return when (action) {
            RegistrationFragmentAction.INITIAL_ACTION_DEFAULT -> {
                RegistrationFragmentViewCommand.DEFAULT
            }
            RegistrationFragmentAction.REGISTER -> {
                RegistrationFragmentViewCommand.REGISTER
            }
        }
    }

    override fun saveAction(action: RegistrationFragmentAction, viewState: RegistrationFragmentState) {
        if (action.mIsInitialAction) {
            viewState.mInitialAction = action
            viewState.actionList.add(action)
        } else {
            viewState.actionList.add(action)
        }
    }

}
