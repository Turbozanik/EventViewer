package com.view.ui.auth.register.configurator


enum class RegistrationFragmentViewCommand(command: Int) {
    DEFAULT(command = 0),
    REGISTER(command = 1);

    private val mCommand: Int = command

    companion object {
        private val map = RegistrationFragmentViewCommand.values()
                .associateBy(
                        RegistrationFragmentViewCommand::mCommand)

        fun getActionValue(
                registrationFragmentViewCommand: RegistrationFragmentViewCommand): Int = registrationFragmentViewCommand.mCommand

        fun getAction(command: Int) = map[command]
    }
}