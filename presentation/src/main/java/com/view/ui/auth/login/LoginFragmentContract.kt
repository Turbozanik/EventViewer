package com.view.ui.auth.login

import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.base.presenter.BaseFragmentPresenter
import com.view.base.presenter.BasePresenterContract
import com.view.base.view.BaseView
import com.view.ui.auth.login.configurator.LoginFragmentAction
import com.view.ui.auth.login.configurator.LoginFragmentConfigurator


interface LoginFragmentContract : BasePresenterContract {

	data class UserCredentials(val email: String, val password: String)

	data class LoginFragmentDto(var userCredentials: UserCredentials,
								val shouldSaveCredentials: Boolean)

	interface LoginFragmentView : BaseView {

		fun getViewData(): LoginFragmentDto

		fun goToRegistrationFragment()

	}

	abstract class LoginFragmentPresenter : BaseFragmentPresenter<LoginFragmentConfigurator, LoginFragmentAction, LoginFragmentContract.LoginFragmentView>() {
		init {
			this.intiConfigurator()
		}
	}

	abstract class LoginFragment : PresenterFragment<LoginFragmentPresenter>(), LoginFragmentContract.LoginFragmentView, ActionProducer<LoginFragmentAction> {

		override fun initView() {
			attachView()
		}

		private fun attachView() {
			this.presenter.attachView(this)
		}
	}

}