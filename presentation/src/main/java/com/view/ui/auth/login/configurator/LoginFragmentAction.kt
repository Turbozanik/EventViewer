package com.view.ui.auth.login.configurator


enum class LoginFragmentAction(action: Int) {
    INITIAL_ACTION_DEFAULT(action = 0);

    private val mAction: Int = action

    companion object {
        private val map = LoginFragmentAction.values()
                .associateBy(LoginFragmentAction::mAction)

        fun getActionValue(
                loginFragmentAction: LoginFragmentAction): Int = loginFragmentAction.mAction

        fun getAction(command: Int) = map[command]
    }

}