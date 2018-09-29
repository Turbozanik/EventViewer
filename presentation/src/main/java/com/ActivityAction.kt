package com


enum class ActivityAction(action: Int) {
    DEFAULT(0),
    OPEN_MAIN_ACTIVITY(action = 1),
    OPEN_AUTH_ACTIVITY(action = 2),
    OPEN_AUTH_ACTIVITY_WITH_NO_SAVED_CREDENTIALS(action = 3),
    OPEN_MAIN_ACTIVITY_WITH_EVENT_LIST_FRAGMENT(action = 4);

    private val mAction: Int = action

    companion object {
        private val map = ActivityAction.values().associateBy(ActivityAction::mAction)

        fun getActionValue(activityAction: ActivityAction): Int = activityAction.mAction

        fun getAction(command: Int) = map[command]
    }

}