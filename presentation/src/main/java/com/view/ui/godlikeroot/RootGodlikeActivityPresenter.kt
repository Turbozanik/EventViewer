package com.view.ui.godlikeroot

import com.EventViewerApp
import com.arellomobile.mvp.InjectViewState
import com.domain.usecase.net.login.LoginUseCase
import com.domain.usecase.prefs.user.GetUserEmailUseCase
import com.domain.usecase.prefs.user.GetUserPasswordUseCase
import com.view.ui.godlikeroot.configurator.RootActivityAction
import com.view.ui.godlikeroot.configurator.RootActivityConfigurator
import io.reactivex.Flowable
import io.reactivex.functions.BiFunction
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class RootGodlikeActivityPresenter : RootGodlikeActivityContract.RootActivityPresenter() {

    @Inject
    lateinit var mGetUserEmailUseCase: GetUserEmailUseCase
    @Inject
    lateinit var mGetUserPasswordUseCase: GetUserPasswordUseCase
    @Inject
    lateinit var mLoginUseCase: LoginUseCase

    override fun consumeActionAndData(action: RootActivityAction?,
                                      data: RootGodlikeActivityContract.RootActivityDto?) {
        if (action != null) {
            when (action) {
                RootActivityAction.DEFAULT -> {
                }
                RootActivityAction.CHECK_CREDENTIALS_IN_SHARED_PREFS -> {
                    addDisposable(inBackground(getUserCredentialsFromSharedPrefs().flatMap {
                        val body: HashMap<String, String> = hashMapOf(
                                "email" to it.first,
                                "password" to it.second)
                        mLoginUseCase.setParams(body).execute()
                    }).subscribe(
                            {
                                if (it != null) {
                                    viewState.goToEventListFragment()
                                } else {
                                    viewState.goToEventListFragment()
                                }
                            },
                            { Timber.e("Error during login") }))
                }
            }
        }
    }

    private fun getUserCredentialsFromSharedPrefs(): Flowable<Pair<String, String>> {
        return Flowable.zip(mGetUserEmailUseCase.execute(),
                            mGetUserPasswordUseCase.execute(),
                            BiFunction { email: String, password: String ->
                                Pair(email, password)
                            })
    }

    override fun injectPresenter() {
        EventViewerApp.getInstance().getDaggerController().rootGodlikeActivitySubComponent?.inject(
                this)
    }

    override fun intiConfigurator(): RootActivityConfigurator {
        return RootActivityConfigurator()
    }

}