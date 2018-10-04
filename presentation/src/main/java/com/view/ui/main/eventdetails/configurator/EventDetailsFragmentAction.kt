package com.view.ui.main.eventdetails.configurator


enum class EventDetailsFragmentAction(action: Int, isInitialAction: Boolean) {
    INITIAL_ACTION_DEFAULT(action = 0, isInitialAction = true);

    internal val mAction: Int = action
    internal val mIsInitialAction: Boolean = isInitialAction

    companion object {
        private val map = EventDetailsFragmentAction.values()
                .associateBy(EventDetailsFragmentAction::mAction)

        fun getAction(command: Int) = map[command]
    }

}