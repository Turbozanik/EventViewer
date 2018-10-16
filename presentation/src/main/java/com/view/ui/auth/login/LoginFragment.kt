package com.view.ui.auth.login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.inputmethod.EditorInfo
import com.FRAGMENT_DATA_KEY
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.view.R
import com.view.ui.auth.AuthActivity
import com.view.ui.auth.login.configurator.LoginFragmentAction
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.fragment_login.*
import timber.log.Timber
import javax.inject.Inject


class LoginFragment : LoginFragmentContract.LoginFragment() {

    @Inject
    lateinit var mPresenter: LoginFragmentPresenter
    private lateinit var mValidationObservable: Observable<Boolean>
    private var mIsFormValid: Boolean = false
    private var mGso: GoogleSignInOptions? = null

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
        initPasswordEditText()
        initSignInFieldsValidation()
        initSignInButton()
        initGoogleSignIn()
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

    private fun initSignInFieldsValidation() {
        mValidationObservable = Observable.combineLatest(
                mEmailInputLayout.getValidityObservable()?.startWith(false),
                mEmailInputLayout.getValidityObservable()?.startWith(false),
                BiFunction { isEmailValid: Boolean, isPasswordValid: Boolean ->
                    isEmailValid && isPasswordValid
                })
        addDisposable(mValidationObservable
                              .subscribe({ isValid: Boolean ->
                                             mIsFormValid = isValid
                                         },
                                         { Timber.e("Error") }))
    }

    private fun initPasswordEditText() {
        mEtPassword?.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                sendAction(LoginFragmentAction.LOGIN_CLICK)
            }
            false
        }
    }

    private fun initSignInButton() {
        mBtnSignIn.setOnClickListener {
            mEmailInputLayout.validate()
            mPasswordLayout.validate()
            if (mIsFormValid)
                sendAction(LoginFragmentAction.LOGIN_CLICK)
        }
    }

    private fun initGoogleSignIn() {
        mGso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
    }

    override fun updateToolbar() {
        (activity as AuthActivity).prepareLoginToolbar()
    }

    override fun handleInitialAction() {
        when (initialAction as LoginFragmentAction?) {
            LoginFragmentAction.LOGIN_WITH_SAVED_CREDENTIALS -> {
                sendAction(LoginFragmentAction.LOGIN_WITH_SAVED_CREDENTIALS)
            }
            else -> {
            }
        }
    }

}
