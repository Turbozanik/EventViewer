package com.view.ui.auth.register

import com.domain.usecase.net.registration.RegisterUserCase
import com.view.ui.auth.register.configurator.RegistrationFragmentAction
import com.view.ui.auth.register.configurator.RegistrationFragmentConfigurator
import com.view.ui.auth.register.configurator.RegistrationFragmentViewCommand
import timber.log.Timber
import javax.inject.Inject


class RegistrationFragmentPresenter @Inject constructor() : RegistrationFragmentContract.RegistrationFragmentPresenter() {

	@Inject
	lateinit var mRegistrationUserCase: RegisterUserCase

	private val mRegistrationFragmentState: RegistrationFragmentState = RegistrationFragmentState()

	override fun intiConfigurator(): RegistrationFragmentConfigurator {
		return RegistrationFragmentConfigurator()
	}

	override fun consumeAction(action: RegistrationFragmentAction?) {
		if (action != null) {
			when (actionConfigurator.produceViewCommand(mRegistrationFragmentState, action)) {
				RegistrationFragmentViewCommand.DEFAULT -> {
					Timber.d("default message")
				}
			}
		}
	}

	private fun register() {
		val credentials = getView()?.getViewData()?.registrationInfo
		val body: Map<String, String?> = hashMapOf(
				"email" to credentials?.email,
				"password" to credentials?.password)
		mRegistrationUserCase.setParams(body).execute()
	}

}