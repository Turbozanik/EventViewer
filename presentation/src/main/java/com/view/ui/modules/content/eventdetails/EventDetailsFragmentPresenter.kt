package com.view.ui.modules.content.eventdetails

import com.arellomobile.mvp.InjectViewState
import com.view.ui.modules.content.eventdetails.configurator.EventDetailsFragmentAction
import com.view.ui.modules.content.eventdetails.configurator.EventDetailsFragmentConfigurator
import com.view.ui.modules.content.eventdetails.configurator.EventDetailsFragmentViewCommand
import timber.log.Timber

@InjectViewState
class EventDetailsFragmentPresenter : EventDetailsFragmentContract.EventDetailsFragmentPresenter() {

    private val mEventDetailsFragmentState: EventDetailsFragmentState = EventDetailsFragmentState()

    override fun intiConfigurator(): EventDetailsFragmentConfigurator {
        return EventDetailsFragmentConfigurator()
    }

    override fun consumeActionAndData(action: EventDetailsFragmentAction?,
                                      data: EventDetailsFragmentContract.EventDetailsFragmentDto?) {
        if (action != null) {
            when (actionConfigurator.produceViewCommand(mEventDetailsFragmentState, action)) {
                EventDetailsFragmentViewCommand.DEFAULT -> {
                    Timber.e("default")
                }
            }
        }
    }

}