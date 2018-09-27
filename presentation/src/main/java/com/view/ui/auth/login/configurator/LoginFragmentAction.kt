package com.view.ui.auth.login.configurator


enum class LoginFragmentAction(action: Int, isInitialState: Boolean) {
    DEFAULT(action = 0, isInitialState = true),
    LOGIN_WITH_SAVED_CREDENTIALS(action = 1, isInitialState = true),
    LOGIN_CLICK(action = 2, isInitialState = false),
    NOT_REGISTERED_CLICK(action = 3, isInitialState = false);

    internal val mAction: Int = action
    internal val mIsInitialState: Boolean = isInitialState

    companion object {
        private val map = LoginFragmentAction.values()
                .associateBy(LoginFragmentAction::mAction)

        fun getAction(command: Int) = map[command]

    }

}