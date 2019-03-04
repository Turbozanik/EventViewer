package com.view.ui.modules.profile.userprofile.configurator


enum class UserProfileFragmentViewCommand(command: Int) {
    DEFAULT(command = 0);

    private val mCommand: Int = command

    companion object {
        private val map = UserProfileFragmentViewCommand.values()
                .associateBy(
                        UserProfileFragmentViewCommand::mCommand)

        fun getActionValue(
                userProfileFragmentViewCommand: UserProfileFragmentViewCommand): Int = userProfileFragmentViewCommand.mCommand

        fun getAction(command: Int) = map[command]
    }
}