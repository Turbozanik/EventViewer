package com.view.ui.main.eventdetails

import com.view.ui.main.eventdetails.configurator.EventDetailsFragmentAction
import com.view.ui.main.eventlist.configurator.EventListFragmentConfigurator
import javax.inject.Inject


class EventDetailsFragmentPresenter @Inject constructor() : EventDetailsFragmentContract.EventDetailsFragmentPresenter() {

    override fun intiConfigurator(): EventListFragmentConfigurator {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun consumeAction(action: EventDetailsFragmentAction?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}