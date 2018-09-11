package com.view.ui.auth.register

import com.domain.usecase.net.registration.RegisterUserCase
import com.view.ui.auth.register.configurator.RegistrationFragmentAction
import com.view.ui.auth.register.configurator.RegistrationFragmentConfigurator
import com.view.ui.auth.register.configurator.RegistrationFragmentViewCommand
import timber.log.Timber
import javax.inject.Inject


class RegistrationFragmentPresenter @Inject constructor() : RegistrationFragmentContract.RegistrationFragmentPresenter(), RegistrationFragmentContract.RegistrationFragmentView {

    @Inject
    lateinit var mRegistrationUserCase: RegisterUserCase

    private val mRegistrationFragmentState: RegistrationFragmentState = RegistrationFragmentState()

    override fun intiConfigurator(): RegistrationFragmentConfigurator {
        return RegistrationFragmentConfigurator()
    }

    override fun consumeAction(action: RegistrationFragmentAction?) {
        if (action != null) {
            when (actionConfigurator.produceViewCommand(mRegistrationFragmentState, action)) {
                RegistrationFragmentViewCommand.DUMMY_COMMAND -> {
                    Timber.d("default message")
                }
            }
        }
    }

    override fun register(email: String, password: String) {
        val body: Map<String, String> = HashMap()
        body.plus(Pair("email", email))
        body.plus(Pair("password", password))
        mRegistrationUserCase.buildFlowable(body)
    }
}