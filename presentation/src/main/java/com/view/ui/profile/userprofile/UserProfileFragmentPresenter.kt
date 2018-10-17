package com.view.ui.profile.userprofile

import com.view.ui.profile.userprofile.configurator.UserProfileFragmentAction
import com.view.ui.profile.userprofile.configurator.UserProfileFragmentConfigurator
import javax.inject.Inject


class UserProfileFragmentPresenter @Inject constructor() : UserProfileFragmentContract.UserProfileFragmentPresenter() {
    override fun intiConfigurator(): UserProfileFragmentConfigurator {
        return UserProfileFragmentConfigurator()
    }

    override fun consumeAction(action: UserProfileFragmentAction?) {

    }
}