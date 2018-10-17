package com.view.ui.profile.userprofile.configurator

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.ui.profile.userprofile.UserProfileFragmentState


class UserProfileFragmentConfigurator : BaseFragmentConfigurator<UserProfileFragmentAction, UserProfileFragmentState, UserProfileFragmentViewCommand>() {
    override fun produceViewCommand(viewState: UserProfileFragmentState,
                                    action: UserProfileFragmentAction): UserProfileFragmentViewCommand {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveAction(action: UserProfileFragmentAction,
                            viewState: UserProfileFragmentState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}