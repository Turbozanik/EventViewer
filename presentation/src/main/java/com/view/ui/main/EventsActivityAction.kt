package com.view.ui.main

enum class EventsActivityAction(action: Int) {
    DEFAULT(action = 0);

    private val mAction: Int = action

    companion object {
        private val map = EventsActivityAction.values().associateBy(
                EventsActivityAction::mAction)

        fun getActionValue(
                eventsActivityAction: EventsActivityAction): Int = eventsActivityAction.mAction

        fun getAction(command: Int) = map[command]
    }

}