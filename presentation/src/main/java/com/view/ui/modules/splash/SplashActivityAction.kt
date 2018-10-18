package com.view.ui.modules.splash


enum class SplashActivityAction(action: Int) {
    NOT_LOGGED_IN(action = 0),
    HAS_SAVED_CREDENTIALS(action = 1),
    HAS_GOOGLE_SAVED_CREDENTIALS(action = 2);

    private val mAction: Int = action

    companion object {
        private val map = SplashActivityAction.values().associateBy(
                SplashActivityAction::mAction)

        fun getActionValue(
                splashActivityAction: SplashActivityAction): Int = splashActivityAction.mAction

        fun getAction(command: Int) = map[command]
    }

}