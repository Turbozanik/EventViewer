package com


enum class ActivityAction(action: Int) {
    NOT_LOGGED_IN(action = 0);

    private val mAction: Int = action

    companion object {
        private val map = ActivityAction.values().associateBy(ActivityAction::mAction)

        fun getActionValue(activityAction: ActivityAction): Int = activityAction.mAction

        fun getAction(command: Int) = map[command]
    }

}