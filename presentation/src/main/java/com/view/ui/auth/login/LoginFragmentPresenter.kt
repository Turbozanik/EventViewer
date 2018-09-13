package com.view.ui.auth.login

import com.domain.models.UserDto
import com.domain.usecase.net.login.LoginUseCase
import com.domain.usecase.prefs.user.GetUserEmailUseCase
import com.domain.usecase.prefs.user.GetUserPasswordUseCase
import com.domain.usecase.prefs.user.SaveUserUseCase
import com.view.ui.auth.login.configurator.LoginFragmentAction
import com.view.ui.auth.login.configurator.LoginFragmentConfigurator
import com.view.ui.auth.login.configurator.LoginFragmentViewCommand
import io.reactivex.Flowable
import io.reactivex.functions.BiFunction
import javax.inject.Inject


class LoginFragmentPresenter @Inject constructor() : LoginFragmentContract.LoginFragmentPresenter() {

    @Inject
    protected lateinit var mLoginUseCase: LoginUseCase
    @Inject
    protected lateinit var mGetUserPasswordUserCase: GetUserPasswordUseCase
    @Inject
    protected lateinit var mGetUserEmailUseCase: GetUserEmailUseCase
    @Inject
    protected lateinit var mSaveUserUseCase: SaveUserUseCase

    private var loginFragmentData: LoginFragmentContract.LoginFragmentDto? = getView()?.getViewData()

    private val mLoginFragmentState: LoginFragmentState = LoginFragmentState()

    override fun intiConfigurator(): LoginFragmentConfigurator {
        return LoginFragmentConfigurator()
    }

    override fun consumeAction(action: LoginFragmentAction?) {
        if (action != null) {
            when (actionConfigurator.produceViewCommand(mLoginFragmentState, action)) {
                LoginFragmentViewCommand.LOGIN -> {
                    login()
                }
                LoginFragmentViewCommand.DEFAULT -> TODO()
                LoginFragmentViewCommand.LOGIN_WITH_SAVED_CREDENTIALS -> TODO()
            }
        }
    }

    private fun login() {
        loginFragmentData = getView()?.getViewData()
        val body: Map<String, String?> = hashMapOf(
                "email" to loginFragmentData?.userCredentials?.email,
                "password" to loginFragmentData?.userCredentials?.password)
        mLoginUseCase.buildFlowable(body).subscribe { userDto: UserDto ->
            mSaveUserUseCase.buildFlowable(Pair(userDto.mUserName, userDto.mUserSecondName))
        }
    }

    fun getUserCredentialsFromSharedPrefs(): LoginFragmentContract.UserCredentials {
        lateinit var userCredentials: LoginFragmentContract.UserCredentials
        Flowable.zip(mGetUserEmailUseCase.buildFlowable(Any()),
                     mGetUserPasswordUserCase.buildFlowable(Any()),
                     BiFunction { email: String, password: String ->
                         LoginFragmentContract.UserCredentials(email, password)
                     }
        ).subscribe {
            userCredentials = it
        }
        return userCredentials
    }

}