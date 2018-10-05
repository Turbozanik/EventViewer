package com.view.ui.main.eventdetails

import com.view.R
import com.view.ui.main.MainActivity
import com.view.ui.main.eventdetails.configurator.EventDetailsFragmentAction
import javax.inject.Inject


class EventDetailsFragment : EventDetailsFragmentContract.EventDetailsFragment() {

    @Inject
    lateinit var mPresenter: EventDetailsFragmentPresenter

    override val presenter: EventDetailsFragmentContract.EventDetailsFragmentPresenter
        get() = mPresenter

    override fun inject() {
        daggerController.eventDetailsFragmentSubComponent?.inject(this)
    }

    override fun addCurrentSubComponent() {
        daggerController.addEventDetailsFragmentSubComponent()
    }

    override fun removeCurrentSubComponent() {
        daggerController.removeEventDetailsFragmentSubComponent()
    }

    override val layoutId: Int
        get() = R.layout.event_details_fragment

    override fun getViewData(): EventDetailsFragmentContract.EventDetailsFragmentDto {
        return EventDetailsFragmentContract.EventDetailsFragmentDto(false)
    }

    override fun sendAction(action: EventDetailsFragmentAction?) {
        presenter.consumeAction(action)
    }

    override fun updateToolbar() {
        (activity as MainActivity).prepareEventDetailsToolbar()
    }

}