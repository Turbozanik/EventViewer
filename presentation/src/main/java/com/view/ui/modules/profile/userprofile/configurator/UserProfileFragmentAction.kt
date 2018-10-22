package com.view.ui.modules.profile.userprofile.configurator


enum class UserProfileFragmentAction(action: Int, isInitialAction: Boolean) {
    INITIAL_ACTION_DEFAULT(action = 0, isInitialAction = true);

    internal val mAction: Int = action
    internal val mIsInitialAction: Boolean = isInitialAction

    companion object {
        private val map = UserProfileFragmentAction.values()
                .associateBy(UserProfileFragmentAction::mAction)

        fun getAction(command: Int) = map[command]
    }

}