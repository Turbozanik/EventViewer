package com.view.ui.modules.profile.userprofile.configurator

import com.view.base.configurator.BaseConfigurator
import com.view.ui.modules.profile.userprofile.UserProfileFragmentState


class UserProfileFragmentConfigurator : BaseConfigurator<UserProfileFragmentAction, UserProfileFragmentState, UserProfileFragmentViewCommand>() {
    override fun produceViewCommand(viewState: UserProfileFragmentState,
                                    action: UserProfileFragmentAction?): UserProfileFragmentViewCommand {
        action?.let {
            return when (action) {
                UserProfileFragmentAction.DEFAULT -> {
                    UserProfileFragmentViewCommand.DEFAULT
                }
            }
        }
    }
}