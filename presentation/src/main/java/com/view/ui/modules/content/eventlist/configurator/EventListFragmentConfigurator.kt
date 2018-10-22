package com.view.ui.modules.content.eventlist.configurator

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.ui.modules.content.eventlist.EventListFragmentState

class EventListFragmentConfigurator : BaseFragmentConfigurator<EventListFragmentAction, EventListFragmentState, EventListFragmentViewCommand>() {
    override fun produceViewCommand(viewState: EventListFragmentState,
                                    action: EventListFragmentAction): EventListFragmentViewCommand {
        return when (action) {
            EventListFragmentAction.INITIAL_ACTION_DEFAULT -> {
                EventListFragmentViewCommand.DEFAULT
            }
            EventListFragmentAction.LOAD_MORE_EVENTS -> {
                EventListFragmentViewCommand.LOAD_MORE_EVENTS
            }
            EventListFragmentAction.RELOAD_EVENTS -> {
                EventListFragmentViewCommand.RELOAD_EVENTS
            }
        }
    }

    override fun saveAction(action: EventListFragmentAction, viewState: EventListFragmentState) {
        if (action.mIsInitialAction) {
            viewState.mInitialAction = action
            viewState.actionList.add(action)
        } else {
            viewState.actionList.add(action)
        }
    }
}