package com.view.ui.main.eventlist

import com.view.R
import com.view.ui.main.eventlist.configurator.EventListFragmentAction
import javax.inject.Inject

class EventListFragment : EventListFragmentContract.EventListFragment() {

    @Inject
    protected lateinit var mPresenter: EventListPresenter

    override val presenter: EventListFragmentContract.EventListPresenter
        get() = mPresenter

    override fun inject() {
        daggerController.eventListFragmentSubComponent?.inject(this)
    }

    override fun addCurrentSubComponent() {
        daggerController.addEventListFragmentSubComponent()
    }

    override fun removeCurrentSubComponent() {
        daggerController.removeEventListFragmentSubComponent()
    }

    override val layoutId: Int
        get() = R.layout.fragment_event_list

    override fun getViewData(): EventListFragmentContract.EventListFragmentDto {
        return EventListFragmentContract.EventListFragmentDto(false)
    }

    override fun sendAction(action: EventListFragmentAction?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}