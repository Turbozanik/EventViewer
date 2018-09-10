package com.view.ui.auth.login.configurator


enum class LoginFragmentAction(action: Int, areParamsRequired: Boolean = false) {
    INITIAL_ACTION_DEFAULT(action = 0);

    internal val mAction: Int = action
    internal val mAreParamsRequired: Boolean = areParamsRequired

    companion object {
        private val map = LoginFragmentAction.values()
                .associateBy(LoginFragmentAction::mAction)

        fun getAction(command: Int) = map[command]

    }

}