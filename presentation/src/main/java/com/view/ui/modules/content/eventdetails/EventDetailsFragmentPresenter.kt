package com.view.ui.modules.content.eventdetails

import com.view.ui.modules.content.eventdetails.configurator.EventDetailsFragmentAction
import com.view.ui.modules.content.eventdetails.configurator.EventDetailsFragmentConfigurator
import com.view.ui.modules.content.eventdetails.configurator.EventDetailsFragmentViewCommand
import timber.log.Timber
import javax.inject.Inject


class EventDetailsFragmentPresenter @Inject constructor() : EventDetailsFragmentContract.EventDetailsFragmentPresenter() {

    private val mEventDetailsFragmentState: EventDetailsFragmentState = EventDetailsFragmentState()

    override fun intiConfigurator(): EventDetailsFragmentConfigurator {
        return EventDetailsFragmentConfigurator()
    }

    override fun consumeAction(action: EventDetailsFragmentAction?) {
        if (action != null) {
            when (actionConfigurator.produceViewCommand(mEventDetailsFragmentState, action)) {
                EventDetailsFragmentViewCommand.DEFAULT -> {
                    Timber.e("default")
                }
            }
        }
    }

}