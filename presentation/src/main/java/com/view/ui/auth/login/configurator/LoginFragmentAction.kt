package com.view.ui.auth.login.configurator


enum class LoginFragmentAction(action: Int) {
    DEFAULT(action = 0),
    LOGIN_WITH_SAVED_CREDENTIALS(action = 1),
    LOGIN_CLICK(action = 2),
    NOT_REGISTERED_CLICK(action = 3);

    internal val mAction: Int = action

    companion object {
        private val map = LoginFragmentAction.values()
                .associateBy(LoginFragmentAction::mAction)

        fun getAction(command: Int) = map[command]

    }

}