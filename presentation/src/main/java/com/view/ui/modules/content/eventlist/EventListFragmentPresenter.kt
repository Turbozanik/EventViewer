package com.view.ui.modules.content.eventlist

import com.arellomobile.mvp.InjectViewState
import com.view.base.presenter.BaseFragmentPresenter
import com.view.ui.modules.content.eventlist.configurator.EventListFragmentAction
import com.view.ui.modules.content.eventlist.configurator.EventListFragmentConfigurator
import com.view.ui.modules.content.eventlist.configurator.EventListFragmentViewCommand

@InjectViewState
class EventListFragmentPresenter : BaseFragmentPresenter<EventListFragmentConfigurator, EventListFragmentAction, EventListFragmentContract.EventListFragmentDto, EventListFragmentView>() {

    private val mEventListFragmentState: EventListFragmentState = EventListFragmentState()

    override fun intiConfigurator(): EventListFragmentConfigurator {
        return EventListFragmentConfigurator()
    }

    override fun consumeActionAndData(action: EventListFragmentAction?,
                                      data: EventListFragmentContract.EventListFragmentDto?) {
        if (action != null) {
            when (actionConfigurator.produceViewCommand(mEventListFragmentState, action)) {
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
}