package com.view.ui.modules.auth.login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.inputmethod.EditorInfo
import com.FRAGMENT_DATA_KEY
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.view.R
import com.view.ui.godlikeroot.RootGodlikeActivity
import com.view.ui.modules.auth.login.configurator.LoginFragmentAction
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.fragment_login.*
import timber.log.Timber

class LoginFragment : LoginFragmentContract.LoginFragment() {

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var mPresenter: LoginPresenter
    val presenter: LoginPresenter get() = mPresenter
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

    override fun addCurrentSubComponent() {
        daggerController.addLoginFragmentSubComponent()
        presenter.injectPresenter()
    }

    override fun removeCurrentSubComponent() {
        daggerController.removeLoginFragmentSubComponent()
    }

    override val layoutId: Int
        get() = R.layout.fragment_login

    override fun initView() {
        initPasswordEditText()
        initSignInFieldsValidation()
        initSignInButton()
        initGoogleSignIn()
        mTvNotRegistered.setOnClickListener {
            sendActionAndData(LoginFragmentAction.NOT_REGISTERED_CLICK, null)
        }
    }

    override fun sendActionAndData(action: LoginFragmentAction?,
                                   data: LoginFragmentContract.LoginFragmentDto?) {
        mPresenter.consumeActionAndData(action, data)
    }

    override fun goToRegistrationFragment() {
        (activity as RootGodlikeActivity).addRegistrationFragment(null)
    }

    private fun initSignInFieldsValidation() {
        mValidationObservable = Observable.combineLatest(
                mEmailInputLayout.getValidityObservable()?.startWith(false),
                mEmailInputLayout.getValidityObservable()?.startWith(false),
                BiFunction { isEmailValid: Boolean, isPasswordValid: Boolean ->
                    isEmailValid && isPasswordValid
                })
        addDisposable(
                mValidationObservable.subscribe({ isValid: Boolean -> mIsFormValid = isValid },
                                                { Timber.e("Error") }))
    }

    private fun initPasswordEditText() {
        mEtPassword?.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                tryToLogin()
            }
            false
        }
    }

    private fun initSignInButton() {
        mBtnSignIn.setOnClickListener {
            mEmailInputLayout.validate()
            mPasswordLayout.validate()
            tryToLogin()
        }
    }

    private fun initGoogleSignIn() {
        mGso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
    }

    override fun updateToolbar() {
        (activity as RootGodlikeActivity).prepareLoginToolbar()
    }

    override fun handleInitialAction() {
        when (initialAction as LoginFragmentAction?) {
            LoginFragmentAction.LOGIN_WITH_SAVED_CREDENTIALS -> {
                sendActionAndData(LoginFragmentAction.LOGIN_WITH_SAVED_CREDENTIALS, null)
            }
            else -> {
            }
        }
    }

    private fun sendLoginAction() {
        sendActionAndData(LoginFragmentAction.LOGIN_CLICK,
                          LoginFragmentContract.LoginFragmentDto(
                                  LoginFragmentContract.UserCredentials(
                                          mEtEmail.text.toString(),
                                          mEtPassword.text.toString()),
                                  mCbSaveCredentials.isChecked))
    }

    private fun tryToLogin() {
        if (mIsFormValid) {
            sendLoginAction()
        }
    }

}
