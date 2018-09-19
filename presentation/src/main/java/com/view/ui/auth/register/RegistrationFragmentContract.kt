package com.view.ui.auth.register

import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.base.presenter.BaseFragmentPresenter
import com.view.base.presenter.BasePresenterContract
import com.view.base.view.BaseView
import com.view.ui.auth.register.configurator.RegistrationFragmentAction
import com.view.ui.auth.register.configurator.RegistrationFragmentConfigurator


interface RegistrationFragmentContract : BasePresenterContract {

	data class RegistrationInfo(var email: String, var password: String)

	data class RegistrationFragmentDto(var registrationInfo: RegistrationInfo,
									   val shouldSaveCredentials: Boolean)

	interface RegistrationFragmentView : BaseView {

		fun getViewData(): RegistrationFragmentDto

		fun goToEventsFragment()

	}

	abstract class RegistrationFragmentPresenter : BaseFragmentPresenter<RegistrationFragmentConfigurator, RegistrationFragmentAction, RegistrationFragmentView>()

	abstract class RegistrationFragment : PresenterFragment<RegistrationFragmentContract.RegistrationFragmentPresenter>(), ActionProducer<RegistrationFragmentAction>, RegistrationFragmentContract.RegistrationFragmentView {

		override fun initView() {
			attachView()
		}

		private fun attachView() {
			this.presenter.attachView(this)
		}
	}

}