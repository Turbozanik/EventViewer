package com.view.ui.main.eventdetails.configurator

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.ui.main.eventdetails.EventDetailsFragmentState


class EventDetailsFragmentConfigurator : BaseFragmentConfigurator<EventDetailsFragmentAction, EventDetailsFragmentState, EventDetailsFragmentViewCommand>() {
    override fun produceViewCommand(viewState: EventDetailsFragmentState,
                                    action: EventDetailsFragmentAction): EventDetailsFragmentViewCommand {
        return when (action) {
            EventDetailsFragmentAction.INITIAL_ACTION_DEFAULT -> {
                EventDetailsFragmentViewCommand.DEFAULT
            }
        }
    }

    override fun saveAction(action: EventDetailsFragmentAction,
                            viewState: EventDetailsFragmentState) {
        if (action.mIsInitialAction) {
            viewState.mInitialAction = action
            viewState.actionList.add(action)
        } else {
            viewState.actionList.add(action)
        }
    }
}