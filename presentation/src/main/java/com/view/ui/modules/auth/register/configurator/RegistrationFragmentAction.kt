package com.view.ui.modules.auth.register.configurator


enum class RegistrationFragmentAction(action: Int, isInitialAction: Boolean) {
    INITIAL_ACTION_DEFAULT(action = 0, isInitialAction = true),
    REGISTER(action = 1, isInitialAction = false);

    internal val mAction: Int = action
    internal val mIsInitialAction: Boolean = isInitialAction

    companion object {
        private val map = RegistrationFragmentAction.values()
                .associateBy(RegistrationFragmentAction::mAction)

        fun getAction(command: Int) = map[command]
    }

}