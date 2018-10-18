package com.view.ui.modules.auth.login

import com.domain.models.UserDto
import com.domain.usecase.net.login.LoginUseCase
import com.domain.usecase.prefs.user.GetUserEmailUseCase
import com.domain.usecase.prefs.user.GetUserPasswordUseCase
import com.domain.usecase.prefs.user.SaveUserToSharedPrefsUseCase
import com.utils.DefaultErrorConsumer
import com.view.ui.modules.auth.login.configurator.LoginFragmentAction
import com.view.ui.modules.auth.login.configurator.LoginFragmentConfigurator
import com.view.ui.modules.auth.login.configurator.LoginFragmentViewCommand
import com.watchers.keepers.UserKeeper
import io.reactivex.Flowable
import io.reactivex.functions.BiFunction
import javax.inject.Inject


class LoginFragmentPresenter @Inject constructor() : LoginFragmentContract.LoginFragmentPresenter() {

    @Inject
    protected lateinit var mLoginUseCase: LoginUseCase
    @Inject
    protected lateinit var mGetUserPasswordUseCase: GetUserPasswordUseCase
    @Inject
    protected lateinit var mGetUserEmailUseCase: GetUserEmailUseCase
    @Inject
    protected lateinit var mSaveUserToSharedPrefsUseCase: SaveUserToSharedPrefsUseCase
    @Inject
    protected lateinit var mUserKeeper: UserKeeper

    private var loginFragmentData: LoginFragmentContract.LoginFragmentDto? = getView()?.getViewData()

    private val mLoginFragmentState: LoginFragmentState = LoginFragmentState()

    override fun intiConfigurator(): LoginFragmentConfigurator {
        return LoginFragmentConfigurator()
    }

    override fun consumeAction(action: LoginFragmentAction?) {
        if (action != null) {
            when (actionConfigurator.produceViewCommand(mLoginFragmentState, action)) {
                LoginFragmentViewCommand.LOGIN -> {
                    loginFragmentData = getView()?.getViewData()
                    login(loginFragmentData?.userCredentials)
                }
                LoginFragmentViewCommand.LOGIN_WITH_SAVED_CREDENTIALS -> {
                    loginFragmentData = getView()?.getViewData()
                    loginFragmentData?.userCredentials = getUserCredentialsFromSharedPrefs()
                    login(loginFragmentData?.userCredentials)
                }
                LoginFragmentViewCommand.DEFAULT -> TODO()
                LoginFragmentViewCommand.GOT_TO_REGISTRATION -> {
                    getView()?.goToRegistrationFragment()
                }
            }
        }
    }

    private fun login(credentials: LoginFragmentContract.UserCredentials?) {
        val body: Map<String, String?> = hashMapOf(
                "email" to credentials?.email,
                "password" to credentials?.password)
        addDisposable(
                inBackground(mLoginUseCase.setParams(body).execute())
                        .doOnNext { userDto: UserDto ->
                            mUserKeeper.user = userDto
                        }.flatMap { userDto: UserDto ->
                            mSaveUserToSharedPrefsUseCase
                                    .setParams(Pair(userDto.mUserName, userDto.mUserSecondName))
                                    .execute()
                        }.subscribe(
                                { getView()?.goToRegistrationFragment() },
                                { DefaultErrorConsumer() })
        )
    }

    private fun getUserCredentialsFromSharedPrefs(): LoginFragmentContract.UserCredentials {
        lateinit var userCredentials: LoginFragmentContract.UserCredentials
        addDisposable(Flowable.zip(mGetUserEmailUseCase.execute(),
                mGetUserPasswordUseCase.execute(),
                BiFunction { email: String, password: String ->
                    LoginFragmentContract.UserCredentials(email,
                                                          password)
                }
        ).subscribe {
            userCredentials = it
        })
        return userCredentials
    }

}