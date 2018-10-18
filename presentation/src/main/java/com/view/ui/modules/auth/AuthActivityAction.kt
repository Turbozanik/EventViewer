package com.view.ui.modules.auth


enum class AuthActivityAction(action: Int) {
    NOT_LOGGED_IN(action = 0),
    HAS_SAVED_CREDENTIALS(action = 1);

    private val mAction: Int = action

    companion object {
        private val map = AuthActivityAction.values().associateBy(
                AuthActivityAction::mAction)

        fun getActionValue(authActivityAction: AuthActivityAction): Int = authActivityAction.mAction

        fun getAction(command: Int) = map[command]
    }

}