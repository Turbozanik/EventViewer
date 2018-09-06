package com.view.ui.register

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.ui.register.configurator.RegistrationFragmentAction
import com.view.ui.register.configurator.RegistrationFragmentConfigurator
import com.view.ui.register.configurator.RegistrationFragmentViewCommand
import timber.log.Timber
import javax.inject.Inject


class RegistrationFragmentPresenter @Inject constructor() : RegistrationFragmentContract.RegistrationFragmentPresenter(), RegistrationFragmentContract.RegistrationFragmentView {

    private val mRegistrationFragmentState: RegistrationFragmentState = RegistrationFragmentState()

    override fun intiConfigurator(): BaseFragmentConfigurator<RegistrationFragmentState, RegistrationFragmentAction, RegistrationFragmentViewCommand> {
        return RegistrationFragmentConfigurator()
    }

    override fun consumeAction(action: RegistrationFragmentAction?) {
        if (action != null) {
            when (getActionConfigurator().produceViewCommand(mRegistrationFragmentState, action)) {
                RegistrationFragmentViewCommand.DUMMY_COMMAND -> {
                    Timber.d("default message")
                }
            }
        }
    }

    override fun register() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}