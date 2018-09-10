package com.view.ui.auth.login.configurator


enum class LoginFragmentViewCommand(command: Int) {
    DUMMY_COMMAND(command = 0);

    private val mCommand: Int = command

    companion object {
        private val map = LoginFragmentViewCommand.values()
                .associateBy(LoginFragmentViewCommand::mCommand)

        fun getActionValue(
                loginFragmentViewCommand: LoginFragmentViewCommand): Int = loginFragmentViewCommand.mCommand

        fun getAction(command: Int) = map[command]
    }
}