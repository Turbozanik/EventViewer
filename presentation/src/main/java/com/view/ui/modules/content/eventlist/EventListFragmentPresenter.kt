package com.view.ui.modules.content.eventlist

import com.EventViewerApp
import com.arellomobile.mvp.InjectViewState
import com.view.ui.modules.content.eventlist.configurator.EventListFragmentAction
import com.view.ui.modules.content.eventlist.configurator.EventListFragmentConfigurator
import com.view.ui.modules.content.eventlist.configurator.EventListFragmentViewCommand

@InjectViewState
class EventListFragmentPresenter : EventListFragmentContract.EventListPresenter() {

    private val mEventListFragmentState: EventListFragmentState = EventListFragmentState()

    override fun intiConfigurator(): EventListFragmentConfigurator {
        return EventListFragmentConfigurator()
    }

    override fun consumeActionAndData(action: EventListFragmentAction?,
                                      data: EventListFragmentContract.EventListFragmentDto?) {
        action?.let { actionCopy: EventListFragmentAction ->
            updateViewState(action)
            when (actionConfigurator.produceViewCommand(mEventListFragmentState, actionCopy)) {
                EventListFragmentViewCommand.DEFAULT -> TODO()
                EventListFragmentViewCommand.LOAD_MORE_EVENTS -> {
                    viewState.onMoreEventsLoaded()
                }
                EventListFragmentViewCommand.RELOAD_EVENTS -> {
                    viewState.onMoreEventsLoaded()
                }
            }
        }
    }

    override fun updateViewState(action: EventListFragmentAction) {

    }

    override fun injectPresenter() {
        EventViewerApp.getInstance().getDaggerController().eventListFragmentSubComponent?.inject(
                this)
    }

}