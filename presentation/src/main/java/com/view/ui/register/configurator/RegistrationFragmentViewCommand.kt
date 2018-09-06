package com.view.ui.register.configurator


enum class RegistrationFragmentViewCommand(command: Int) {
    DUMMY_COMMAND(command = 0);

    private val mCommand: Int = command

    companion object {
        private val map = RegistrationFragmentViewCommand.values()
                .associateBy(RegistrationFragmentViewCommand::mCommand)

        fun getActionValue(
                registrationFragmentViewCommand: RegistrationFragmentViewCommand): Int = registrationFragmentViewCommand.mCommand

        fun getAction(command: Int) = map[command]
    }
}