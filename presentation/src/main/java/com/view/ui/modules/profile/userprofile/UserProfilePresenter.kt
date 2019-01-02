package com.view.ui.modules.profile.userprofile

import com.EventViewerApp
import com.arellomobile.mvp.InjectViewState
import com.view.ui.modules.profile.userprofile.configurator.UserProfileFragmentAction
import com.view.ui.modules.profile.userprofile.configurator.UserProfileFragmentConfigurator
import com.watchers.keepers.UserKeeper
import javax.inject.Inject


@InjectViewState
class UserProfilePresenter : UserProfileFragmentContract.UserProfilePresenter() {

    @Inject
    lateinit var mUserKeeper: UserKeeper

    override fun intiConfigurator(): UserProfileFragmentConfigurator {
        return UserProfileFragmentConfigurator()
    }

    override fun consumeActionAndData(action: UserProfileFragmentAction?,
                                      data: UserProfileFragmentContract.UserProfileFragmentDto?) {
        action?.let {
            updateViewState()
            when (action) {
                UserProfileFragmentAction.DEFAULT -> {
                    viewState.populateProfileData(mUserKeeper.user)
                }
            }
        }
    }

    override fun updateViewState() {

    }

    override fun injectPresenter() {
        EventViewerApp.getInstance().getDaggerController().userProfileFragmentSubComponent?.inject(
                this)
    }

}