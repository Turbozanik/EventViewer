package com.view.ui.modules.content.eventdetails

import com.EventViewerApp
import com.arellomobile.mvp.InjectViewState
import com.view.ui.modules.content.eventdetails.configurator.EventDetailsFragmentAction
import com.view.ui.modules.content.eventdetails.configurator.EventDetailsFragmentConfigurator
import com.view.ui.modules.content.eventdetails.configurator.EventDetailsFragmentViewCommand
import timber.log.Timber

@InjectViewState
class EventDetailsPresenter : EventDetailsFragmentContract.EventDetailsPresenter() {

    private val mEventDetailsFragmentState: EventDetailsFragmentState = EventDetailsFragmentState()

    override fun intiConfigurator(): EventDetailsFragmentConfigurator {
        return EventDetailsFragmentConfigurator()
    }

    override fun consumeActionAndData(action: EventDetailsFragmentAction?,
                                      data: EventDetailsFragmentContract.EventDetailsFragmentDto?) {
        action?.let {
            updateViewState(action)
            when (actionConfigurator.produceViewCommand(mEventDetailsFragmentState, action)) {
                EventDetailsFragmentViewCommand.DEFAULT -> {
                    Timber.e("default")
                }
            }
        }
    }

    override fun updateViewState(action: EventDetailsFragmentAction) {

    }

    override fun injectPresenter() {
        EventViewerApp.getInstance().getDaggerController().eventDetailsFragmentSubComponent?.inject(
                this)
    }

}