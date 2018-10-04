package com.view.ui.main.eventdetails.configurator

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.ui.main.eventdetails.EventDetailsFragmentState
import com.view.ui.main.eventlist.configurator.EventListFragmentViewCommand


class EventDetailsFragmentConfigurator : BaseFragmentConfigurator<EventDetailsFragmentAction, EventDetailsFragmentState, EventListFragmentViewCommand>() {
    override fun produceViewCommand(viewState: EventDetailsFragmentState,
                                    action: EventDetailsFragmentAction): EventListFragmentViewCommand {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveAction(action: EventDetailsFragmentAction,
                            viewState: EventDetailsFragmentState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}