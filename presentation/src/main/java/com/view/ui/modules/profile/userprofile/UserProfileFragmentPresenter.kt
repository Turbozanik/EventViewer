package com.view.ui.modules.profile.userprofile

import com.arellomobile.mvp.InjectViewState
import com.view.ui.modules.profile.userprofile.configurator.UserProfileFragmentAction
import com.view.ui.modules.profile.userprofile.configurator.UserProfileFragmentConfigurator
import javax.inject.Inject


@InjectViewState
class UserProfileFragmentPresenter @Inject constructor() : UserProfileFragmentContract.UserProfileFragmentPresenter() {

    override fun intiConfigurator(): UserProfileFragmentConfigurator {
        return UserProfileFragmentConfigurator()
    }

    override fun consumeActionAndData(action: UserProfileFragmentAction?,
                                      data: UserProfileFragmentContract.UserProfileFragmentDto?) {
        when (action) {

            UserProfileFragmentAction.INITIAL_ACTION_DEFAULT -> {
            }
            null -> {
            }
        }
    }
}