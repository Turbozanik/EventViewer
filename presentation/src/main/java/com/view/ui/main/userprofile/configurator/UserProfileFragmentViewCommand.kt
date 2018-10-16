package com.view.ui.main.userprofile.configurator


enum class UserProfileFragmentViewCommand(command: Int) {
    DEFAULT(command = 0),
    REGISTER(command = 1);

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