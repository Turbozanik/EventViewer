package com.view.ui.auth.login.configurator


enum class LoginFragmentAction(action: Int) {
    LOGIN(action = 0);

    internal val mAction: Int = action

    companion object {
        private val map = LoginFragmentAction.values()
                .associateBy(LoginFragmentAction::mAction)

        fun getAction(command: Int) = map[command]

    }

}