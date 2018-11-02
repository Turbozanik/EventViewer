package com.view.ui.modules.content.eventlist.configurator

import com.view.base.BaseAction


enum class EventListFragmentAction(action: Int, isInitialAction: Boolean) : BaseAction {
    INITIAL_ACTION_DEFAULT(action = 0, isInitialAction = true),
    LOAD_MORE_EVENTS(action = 1, isInitialAction = false),
    RELOAD_EVENTS(action = 2, isInitialAction = false);

    override val mActionValue: Int = action
    override val mIsInitialAction: Boolean = isInitialAction

    companion object {
        private val map = EventListFragmentAction.values()
                .associateBy(EventListFragmentAction::mActionValue)

        fun getAction(command: Int) = map[command]
    }

}