package com.view.ui.auth.login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.inputmethod.EditorInfo
import com.FRAGMENT_DATA_KEY
import com.utils.RxUtils
import com.view.R
import com.view.ui.auth.AuthActivity
import com.view.ui.auth.login.configurator.LoginFragmentAction
import kotlinx.android.synthetic.main.fragment_login.*
import timber.log.Timber
import javax.inject.Inject


class LoginFragment : LoginFragmentContract.LoginFragment() {

	@Inject
	lateinit var mPresenter: LoginFragmentPresenter
	private var mIsEmailValid: Boolean = false
	private var mIsPasswordValid: Boolean = false

	companion object {
		fun createNewInstance(): LoginFragment {
			return LoginFragment()
		}

		fun addInitialAction(fragment: Fragment, initialAction: LoginFragmentAction) {
			val args = Bundle()
			args.putSerializable(FRAGMENT_DATA_KEY, initialAction)
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
		super.initView()
		initEmailEditText()
		initPasswordEditText()
		initSignInButton()
		mTvNotRegistered.setOnClickListener {
			sendAction(LoginFragmentAction.NOT_REGISTERED_CLICK)
		}
	}

	override val presenter: LoginFragmentPresenter
		get() {
			return mPresenter
		}

	override fun sendAction(action: LoginFragmentAction?) {
		mPresenter.consumeAction(action)
	}

	override fun getViewData(): LoginFragmentContract.LoginFragmentDto {
		return LoginFragmentContract.LoginFragmentDto(
				LoginFragmentContract.UserCredentials(mEtEmail.text.toString(),
													  mEtPassword.text.toString()),
				mCbSaveCredentials.isChecked)
	}

	override fun goToRegistrationFragment() {
		(activity as AuthActivity).showRegistrationFragment(null)
	}

	private fun initEmailEditText() {
		addDisposable(RxUtils.subscribeEditText(mEtEmail)
							  .doOnNext { mEmailInputLayout.isValid() }
							  .subscribe({}, { Timber.e("Error") }))
	}

	private fun initPasswordEditText() {
		addDisposable(RxUtils.subscribeEditText(mEtPassword)
							  .doOnNext { mPasswordLayout.isValid() }
							  .subscribe({}, { Timber.e("Error") }))

		mEtPassword?.setOnEditorActionListener { v, actionId, event ->
			if (actionId == EditorInfo.IME_ACTION_DONE) {
				sendAction(LoginFragmentAction.LOGIN_CLICK)
			}
			false
		}
	}

	private fun initSignInButton() {
		mBtnSignIn.setOnClickListener {
			val isEmailValid = mEmailInputLayout.isValid()
			val isPasswordValid = mPasswordLayout.isValid()
			if (isEmailValid && isPasswordValid) {
				sendAction(LoginFragmentAction.LOGIN_CLICK)
			}
		}
	}

}
