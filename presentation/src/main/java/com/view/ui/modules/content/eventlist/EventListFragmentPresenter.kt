package com.view.ui.modules.content.eventlist

import com.view.ui.modules.content.eventlist.configurator.EventListFragmentAction
import com.view.ui.modules.content.eventlist.configurator.EventListFragmentConfigurator
import com.view.ui.modules.content.eventlist.configurator.EventListFragmentViewCommand
import javax.inject.Inject

class EventListFragmentPresenter @Inject constructor() : EventListFragmentContract.EventListPresenter() {

    private val mEventListFragmentState: EventListFragmentState = EventListFragmentState()

    override fun intiConfigurator(): EventListFragmentConfigurator {
        return EventListFragmentConfigurator()
    }

    override fun consumeAction(action: EventListFragmentAction?) {
        if (action != null) {
            when (actionConfigurator.produceViewCommand(mEventListFragmentState, action)) {
                EventListFragmentViewCommand.DEFAULT -> TODO()
            }
        }
    }
}