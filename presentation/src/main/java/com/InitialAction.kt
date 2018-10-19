package com


enum class InitialAction(action: Int) {
    DEFAULT(0),
    OPEN_MAIN(action = 1),
    OPEN_AUTH(action = 2),
    OPEN_AUTH_WITH_NO_SAVED_CREDENTIALS(action = 3),
    OPEN_AUTH_WITH_SAVED_CREDENTIALS(action = 4),
    OPEN_MAIN_WITH_EVENT_LIST_FRAGMENT(action = 5);

    private val mAction: Int = action

    companion object {
        private val map = InitialAction.values().associateBy(InitialAction::mAction)

        fun getActionValue(initialAction: InitialAction): Int = initialAction.mAction

        fun getAction(command: Int) = map[command]
    }

}