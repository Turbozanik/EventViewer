package com.view.ui.modules.profile.userprofile.configurator

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.ui.modules.profile.userprofile.UserProfileFragmentState


class UserProfileFragmentConfigurator : BaseFragmentConfigurator<UserProfileFragmentAction, UserProfileFragmentState, UserProfileFragmentViewCommand>() {
    override fun produceViewCommand(viewState: UserProfileFragmentState,
                                    action: UserProfileFragmentAction): UserProfileFragmentViewCommand {
        return when (action) {

            UserProfileFragmentAction.INITIAL_ACTION_DEFAULT -> {
                UserProfileFragmentViewCommand.DEFAULT
            }
        }
    }

    override fun saveAction(action: UserProfileFragmentAction,
                            viewState: UserProfileFragmentState) {
        if (action.mIsInitialAction) {
            viewState.mInitialAction = action
            viewState.actionList.add(action)
        } else {
            viewState.actionList.add(action)
        }
    }
}