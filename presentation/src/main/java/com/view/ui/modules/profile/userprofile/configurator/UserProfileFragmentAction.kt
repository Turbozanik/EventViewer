package com.view.ui.modules.profile.userprofile.configurator

import com.view.base.BaseAction


enum class UserProfileFragmentAction(action: Int, isInitialAction: Boolean) : BaseAction {
    INITIAL_ACTION_DEFAULT(action = 0, isInitialAction = true);

    override val mActionValue: Int = action
    override val mIsInitialAction: Boolean = isInitialAction

    companion object {
        private val map = UserProfileFragmentAction.values()
                .associateBy(UserProfileFragmentAction::mActionValue)

        fun getAction(command: Int) = map[command]
    }

}