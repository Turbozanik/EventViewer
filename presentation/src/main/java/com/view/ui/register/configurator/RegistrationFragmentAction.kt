package com.view.ui.register.configurator


enum class RegistrationFragmentAction(action: Int) {
    INITIAL_ACTION_DEFAULT(action = 0);

    private val mAction: Int = action

    companion object {
        private val map = RegistrationFragmentAction.values()
                .associateBy(RegistrationFragmentAction::mAction)

        fun getActionValue(
                registrationFragmentAction: RegistrationFragmentAction): Int = registrationFragmentAction.mAction

        fun getAction(command: Int) = map[command]
    }

}