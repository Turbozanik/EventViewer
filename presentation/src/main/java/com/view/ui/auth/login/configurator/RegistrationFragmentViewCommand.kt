package com.view.ui.auth.login.configurator


enum class LoginFragmentViewCommand(command: Int) {
    DEFAULT(command = 0),
    LOGIN_SAVED_CREDENTIALS(command = 1),
    LOGIN(command = 2);

    private val mCommand: Int = command

    companion object {
        private val map = LoginFragmentViewCommand.values()
                .associateBy(LoginFragmentViewCommand::mCommand)

        fun getActionValue(
                loginFragmentViewCommand: LoginFragmentViewCommand): Int = loginFragmentViewCommand.mCommand

        fun getAction(command: Int) = map[command]
    }
}