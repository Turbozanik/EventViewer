package com.view.ui.modules.content.eventlist.configurator

import com.view.base.configurator.BaseConfigurator
import com.view.ui.modules.content.eventlist.EventListFragmentState

class EventListFragmentConfigurator : BaseConfigurator<EventListFragmentAction, EventListFragmentState, EventListFragmentViewCommand>() {
    override fun produceViewCommand(viewState: EventListFragmentState,
                                    action: EventListFragmentAction): EventListFragmentViewCommand {
        saveAction(action, viewState)
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
}