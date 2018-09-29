package com.view.ui.main.eventlist

import com.view.ui.main.eventlist.configurator.EventListFragmentAction
import com.view.ui.main.eventlist.configurator.EventListFragmentConfigurator
import javax.inject.Inject

class EventListPresenter @Inject constructor() : EventListFragmentContract.EventListPresenter() {

    private val mEventListFragmentState: EventListFragmentState = EventListFragmentState()

    override fun intiConfigurator(): EventListFragmentConfigurator {
        return EventListFragmentConfigurator()
    }

    override fun consumeAction(action: EventListFragmentAction?) {
        if (action != null) {
            when (actionConfigurator.produceViewCommand(mEventListFragmentState, action)) {

            }
        }
    }
}