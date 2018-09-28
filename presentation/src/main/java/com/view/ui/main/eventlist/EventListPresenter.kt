package com.view.ui.main.eventlist

import com.view.ui.main.eventlist.configurator.EventListFragmentAction
import com.view.ui.main.eventlist.configurator.EventListFragmentConfigurator
import javax.inject.Inject

class EventListPresenter @Inject constructor() : EventListFragmentContract.EventListPresenter() {

    override fun intiConfigurator(): EventListFragmentConfigurator {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun consumeAction(action: EventListFragmentAction?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}