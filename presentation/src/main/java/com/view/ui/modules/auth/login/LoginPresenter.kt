package com.view.ui.modules.auth.login

import com.EventViewerApp
import com.arellomobile.mvp.InjectViewState
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

@InjectViewState
class LoginPresenter : LoginFragmentContract.LoginPresenter() {

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

    private val mLoginFragmentState: LoginFragmentState = LoginFragmentState()

    override fun intiConfigurator(): LoginFragmentConfigurator {
        return LoginFragmentConfigurator()
    }

    override fun consumeActionAndData(action: LoginFragmentAction?,
                                      data: LoginFragmentContract.LoginFragmentDto?) {
        if (action != null) {
            when (actionConfigurator.produceViewCommand(mLoginFragmentState, action)) {
                LoginFragmentViewCommand.LOGIN -> {
                    login(data?.userCredentials)
                }
                LoginFragmentViewCommand.LOGIN_WITH_SAVED_CREDENTIALS -> {
                    login(getUserCredentialsFromSharedPrefs())
                }
                LoginFragmentViewCommand.DEFAULT -> TODO()
                LoginFragmentViewCommand.GOT_TO_REGISTRATION -> {
                    viewState.goToRegistrationFragment()
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
                                { viewState.goToRegistrationFragment() },
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

    override fun injectPresenter() {
        EventViewerApp.getInstance().getDaggerController().loginFragmentSubComponent?.inject(this)
    }

}