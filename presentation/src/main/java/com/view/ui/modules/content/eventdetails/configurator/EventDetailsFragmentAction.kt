package com.view.ui.modules.content.eventdetails.configurator

import com.view.base.BaseAction


enum class EventDetailsFragmentAction(action: Int, isInitialAction: Boolean) : BaseAction {
    INITIAL_ACTION_DEFAULT(action = 0, isInitialAction = true);

    override val mActionValue: Int = action
    override val mIsInitialAction: Boolean = isInitialAction

    companion object {
        private val map = EventDetailsFragmentAction.values()
                .associateBy(EventDetailsFragmentAction::mActionValue)

        fun getAction(command: Int) = map[command]
    }

}