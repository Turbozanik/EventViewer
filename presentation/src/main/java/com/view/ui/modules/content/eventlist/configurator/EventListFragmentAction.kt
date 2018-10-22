package com.view.ui.modules.content.eventlist.configurator


enum class EventListFragmentAction(action: Int, isInitialAction: Boolean) {
    INITIAL_ACTION_DEFAULT(action = 0, isInitialAction = true),
    LOAD_MORE_EVENTS(action = 1, isInitialAction = false),
    RELOAD_EVENTS(action = 2, isInitialAction = false);

    internal val mAction: Int = action
    internal val mIsInitialAction: Boolean = isInitialAction

    companion object {
        private val map = EventListFragmentAction.values()
                .associateBy(
                        EventListFragmentAction::mAction)

        fun getAction(command: Int) = map[command]
    }

}