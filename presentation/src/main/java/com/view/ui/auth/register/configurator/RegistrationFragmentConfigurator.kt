package com.view.ui.auth.register.configurator

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.ui.auth.register.RegistrationFragmentState

class RegistrationFragmentConfigurator : BaseFragmentConfigurator<RegistrationFragmentAction, RegistrationFragmentState, RegistrationFragmentViewCommand>() {

    override fun produceViewCommand(viewState: RegistrationFragmentState,
                                    action: RegistrationFragmentAction): RegistrationFragmentViewCommand {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleActionType(action: RegistrationFragmentAction, viewState: RegistrationFragmentState) {
        if (action.mIsInitialAction) {
            viewState.mInitialAction = action
            viewState.actionList.add(action)
        } else {
            viewState.actionList.add(action)
        }
    }

}
