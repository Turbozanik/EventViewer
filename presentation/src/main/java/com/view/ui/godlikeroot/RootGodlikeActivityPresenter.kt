package com.view.ui.godlikeroot

import com.EventViewerApp
import com.arellomobile.mvp.InjectViewState
import com.domain.usecase.net.login.LoginUseCase
import com.domain.usecase.prefs.user.GetUserEmailUseCase
import com.domain.usecase.prefs.user.GetUserPasswordUseCase
import com.view.ui.godlikeroot.configurator.RootActivityAction
import com.view.ui.godlikeroot.configurator.RootActivityConfigurator
import com.view.ui.godlikeroot.configurator.RootActivityViewCommand
import io.reactivex.Flowable
import io.reactivex.functions.BiFunction
import javax.inject.Inject

@InjectViewState
class RootGodlikeActivityPresenter : RootGodlikeActivityContract.RootActivityPresenter() {

    @Inject
    lateinit var mGetUserEmailUseCase: GetUserEmailUseCase
    @Inject
    lateinit var mGetUserPasswordUseCase: GetUserPasswordUseCase
    @Inject
    lateinit var mLoginUseCase: LoginUseCase

    private val mRootGodlikeActivityState: RootGodlikeActivityState = RootGodlikeActivityState()

    override fun consumeActionAndData(action: RootActivityAction?,
                                      data: RootGodlikeActivityContract.RootActivityDto?) {
        action?.let { actionCopy: RootActivityAction ->
            when (actionConfigurator.produceViewCommand(mRootGodlikeActivityState, actionCopy)) {
                RootActivityViewCommand.DEFAULT -> {
                    addDisposable(inBackground(getUserCredentialsFromSharedPrefs().flatMap {
                        val body: HashMap<String, String> = hashMapOf(
                                "email" to it.first,
                                "password" to it.second)
                        mLoginUseCase.setParams(body).execute()
                    }).subscribe({ viewState.goToEventListFragment() },
                                 { viewState.goToEventListFragment() }))
                }
                RootActivityViewCommand.OPEN_CONFERENCE_SCREEN -> {
                    viewState.goToConferenceFragment()
                }
                RootActivityViewCommand.OPEN_EVENT_LIST_SCREEN -> {
                    viewState.goToEventListFragment()
                }
                RootActivityViewCommand.OPEN_EVENT_DETAILS_SCREEN -> {
                }
                RootActivityViewCommand.OPEN_AUTH_SCREEN -> {
                }

                RootActivityViewCommand.GO_BACK -> {
                    viewState.goBack()
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