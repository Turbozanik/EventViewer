package com.view.ui.auth.login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.inputmethod.EditorInfo
import com.Constants
import com.view.R
import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.ui.auth.login.configurator.LoginFragmentAction
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject


class LoginFragment : PresenterFragment<LoginFragmentContract.LoginFragmentPresenter>(), LoginFragmentContract.LoginFragmentView, ActionProducer<LoginFragmentAction> {

	@Inject
	lateinit var mPresenter: LoginFragmentPresenter

	companion object {
		fun createNewInstance(): LoginFragment {
			return LoginFragment()
		}

		fun addInitialAction(fragment: Fragment, initialAction: LoginFragmentAction) {
			val args = Bundle()
			args.putSerializable(Constants.FRAGMENT_DATA_KEY, initialAction)
			fragment.arguments = args
		}
	}

	override fun inject() {
		daggerController.loginFragmentSubComponent?.inject(this)
	}

	override fun addCurrentSubComponent() {
		daggerController.addLoginFragmentSubComponent()
	}

	override fun removeCurrentSubComponent() {
		daggerController.removeLoginFragmentSubComponent()
	}

	override val layoutId: Int
		get() = R.layout.fragment_login

	override fun initView() {
		mEtPassword?.setOnEditorActionListener { v, actionId, event ->
			if (actionId == EditorInfo.IME_ACTION_DONE) {
				sendAction(LoginFragmentAction.LOGIN)
			}
			false
		}
		mBtnSignIn.setOnClickListener {
			sendAction(LoginFragmentAction.LOGIN)
		}
	}

	override val presenter: LoginFragmentPresenter
		get() {
			return mPresenter
		}

	override fun sendAction(action: LoginFragmentAction?) {
		mPresenter.consumeAction(action)
	}

	private fun getUserCredentials(): LoginFragmentContract.UserCredentials {
		return when (initialAction) {
			LoginFragmentAction.LOGIN_WITH_SAVED_CREDENTIALS -> {
				mPresenter.getUserCredentialsFromSharedPrefs()
			}
			LoginFragmentAction.LOGIN -> {
				LoginFragmentContract.UserCredentials(mEtEmail?.text.toString(),
													  mEtPassword?.text.toString())
			}
			else -> {
				throw IllegalArgumentException("Unknown action")
			}
		}
	}

	override fun getViewData(): LoginFragmentContract.LoginFragmentDto {
		return LoginFragmentContract.LoginFragmentDto(getUserCredentials(),
													  mCbSaveCredentials.isChecked)
	}

}
