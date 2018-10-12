package com.view.ui.main.eventdetails

import android.os.Bundle
import android.support.v4.app.Fragment
import com.FRAGMENT_DATA_KEY
import com.view.R
import com.view.ui.main.MainActivity
import com.view.ui.main.eventdetails.configurator.EventDetailsFragmentAction
import kotlinx.android.synthetic.main.fragment_event_details.*
import javax.inject.Inject


class EventDetailsFragment : EventDetailsFragmentContract.EventDetailsFragment() {

    companion object {
        fun createNewInstance(): EventDetailsFragment {
            return EventDetailsFragment()
        }

        fun addInitialAction(fragment: Fragment, initialAction: EventDetailsFragmentAction) {
            val args = Bundle()
            args.putSerializable(FRAGMENT_DATA_KEY, initialAction)
            fragment.arguments = args
        }
    }

    @Inject
    lateinit var mPresenter: EventDetailsFragmentPresenter

    override val presenter: EventDetailsFragmentContract.EventDetailsFragmentPresenter
        get() = mPresenter

    override fun initView() {
        super.initView()
        mTvTitle.text = "Title"
        mTvDescription.text = "Description text"
        mTvAddress.text = getString(R.string.address_format, "Kolasa 51/2")
        mTvStartDate.text = getString(R.string.start_date_format, "14/11/1994")
        mTvEndDate.text = getString(R.string.start_date_format, "14/11/1994")
        mTvLocalEventTimezone.text = getString(R.string.local_timezone_format, "UTC")
        mTvPhone.text = getString(R.string.phone_format, "+375293070409")
        mTvEmail.text = getString(R.string.email_format, "roma_lapa@mail.ru")
    }

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
        get() = R.layout.fragment_event_details

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