package com.view.ui.modules.profile.userprofile.configurator

import com.view.base.configurator.BaseConfigurator
import com.view.ui.modules.profile.userprofile.UserProfileFragmentState


class UserProfileFragmentConfigurator : BaseConfigurator<UserProfileFragmentAction, UserProfileFragmentState, UserProfileFragmentViewCommand>() {
    override fun produceViewCommand(viewState: UserProfileFragmentState,
                                    action: UserProfileFragmentAction): UserProfileFragmentViewCommand {
        saveAction(action, viewState)
        return when (action) {
            UserProfileFragmentAction.INITIAL_ACTION_DEFAULT -> {
                UserProfileFragmentViewCommand.DEFAULT
            }
        }
    }
}