package com.view.ui.modules.profile.userprofile

import com.EventViewerApp
import com.arellomobile.mvp.InjectViewState
import com.view.ui.modules.profile.userprofile.configurator.UserProfileFragmentAction
import com.view.ui.modules.profile.userprofile.configurator.UserProfileFragmentConfigurator
import com.view.ui.modules.profile.userprofile.configurator.UserProfileFragmentViewCommand
import com.watchers.keepers.UserKeeper
import javax.inject.Inject

@InjectViewState
class UserProfileFragmentPresenter : UserProfileFragmentContract.UserProfilePresenter() {

    @Inject
    lateinit var mUserKeeper: UserKeeper

    private val mUserProfileFragmentState: UserProfileFragmentState = UserProfileFragmentState()

    override fun intiConfigurator(): UserProfileFragmentConfigurator {
        return UserProfileFragmentConfigurator()
    }

    override fun consumeActionAndData(action: UserProfileFragmentAction?,
                                      data: UserProfileFragmentContract.UserProfileFragmentDto?) {
        action?.let { actionCopy: UserProfileFragmentAction ->
            updateViewState(actionCopy)
            when (actionConfigurator.produceViewCommand(mUserProfileFragmentState, actionCopy)) {
                UserProfileFragmentViewCommand.DEFAULT -> {
                    viewState.populateProfileData(mUserKeeper.user)
                }
            }
        }
    }

    override fun updateViewState(action: UserProfileFragmentAction) {

    }

    override fun injectPresenter() {
        EventViewerApp.getInstance().getDaggerController().userProfileFragmentSubComponent?.inject(
                this)
    }

}