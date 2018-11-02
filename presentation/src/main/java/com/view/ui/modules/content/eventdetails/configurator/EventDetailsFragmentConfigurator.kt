package com.view.ui.modules.content.eventdetails.configurator

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.ui.modules.content.eventdetails.EventDetailsFragmentState


class EventDetailsFragmentConfigurator : BaseFragmentConfigurator<EventDetailsFragmentAction, EventDetailsFragmentState, EventDetailsFragmentViewCommand>() {
    override fun produceViewCommand(viewState: EventDetailsFragmentState,
                                    action: EventDetailsFragmentAction): EventDetailsFragmentViewCommand {
        saveAction(action, viewState)
        return when (action) {
            EventDetailsFragmentAction.INITIAL_ACTION_DEFAULT -> {
                EventDetailsFragmentViewCommand.DEFAULT
            }
        }
    }
}