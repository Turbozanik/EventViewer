package com.view.ui.godlikeroot

import com.EventViewerApp
import com.arellomobile.mvp.InjectViewState
import com.domain.models.UserDto
import com.domain.usecase.net.login.LoginUseCase
import com.domain.usecase.prefs.user.GetUserEmailUseCase
import com.domain.usecase.prefs.user.GetUserPasswordUseCase
import com.view.ui.godlikeroot.configurator.RootActivityAction
import com.view.ui.godlikeroot.configurator.RootActivityConfigurator
import com.view.ui.godlikeroot.configurator.RootActivityViewCommand
import com.watchers.keepers.UserKeeper
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
    @Inject
    lateinit var mUserKeeper: UserKeeper

    private val mRootGodlikeActivityState: RootGodlikeActivityState = RootGodlikeActivityState()

    override fun consumeActionAndData(action: RootActivityAction?,
                                      data: RootGodlikeActivityContract.RootActivityDto?) {
        action?.let { actionCopy: RootActivityAction ->
            updateViewState(action)
            when (actionConfigurator.produceViewCommand(mRootGodlikeActivityState, actionCopy)) {
                RootActivityViewCommand.DEFAULT -> {
                    addDisposable(inBackground(getUserCredentialsFromSharedPrefs().flatMap {
                        val body: HashMap<String, String> = hashMapOf(
                                "email" to it.first,
                                "password" to it.second)
                        mLoginUseCase.setParams(body).execute()
                    }).subscribe({
                                     mUserKeeper.user = it
                                     viewState.goToEventListFragment()
                                 },
                                 {
                                     //todo remove next line
                                     mUserKeeper.user = UserDto(1, "Roman", "Lapa")
                                     viewState.goToEventListFragment()
                                 }))
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
                RootActivityViewCommand.OPEN_USER_PROFILE -> {
                    viewState.goToProfileFragment()
                }
                RootActivityViewCommand.OPEN_COMPANY_DETAILS -> {
                    viewState.goToCompanyDetailsFragment()
                }
                RootActivityViewCommand.OPEN_COMPANY_LIST -> {
                    viewState.goToCompanyListFragment()
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

    override fun updateViewState(action: RootActivityAction) {

    }

    override fun injectPresenter() {
        EventViewerApp.getInstance().getDaggerController().rootGodlikeActivitySubComponent?.inject(
                this)
    }

    override fun intiConfigurator(): RootActivityConfigurator {
        return RootActivityConfigurator()
    }

}