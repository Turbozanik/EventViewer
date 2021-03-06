package com.view.ui.modules.auth.register.configurator

import com.view.base.configurator.BaseConfigurator
import com.view.ui.modules.auth.register.RegistrationFragmentState

class RegistrationFragmentConfigurator : BaseConfigurator<RegistrationFragmentAction, RegistrationFragmentState, RegistrationFragmentViewCommand>() {
    override fun produceViewCommand(viewState: RegistrationFragmentState,
                                    action: RegistrationFragmentAction?): RegistrationFragmentViewCommand {
        action?.let {
            return when (it) {
                RegistrationFragmentAction.INITIAL_ACTION_DEFAULT -> {
                    RegistrationFragmentViewCommand.DEFAULT
                }
                RegistrationFragmentAction.REGISTER -> {
                    RegistrationFragmentViewCommand.REGISTER
                }
            }
        }
    }
}
