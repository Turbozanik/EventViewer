package com.view.ui.modules.content.eventdetails

import android.os.Bundle
import android.support.v4.app.Fragment
import com.FRAGMENT_DATA_KEY
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.view.R
import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.ui.godlikeroot.RootGodlikeActivity
import com.view.ui.modules.content.eventdetails.configurator.EventDetailsFragmentAction
import kotlinx.android.synthetic.main.fragment_event_details.*


class EventDetailsFragment : PresenterFragment(), EventDetailsFragmentView, ActionProducer<EventDetailsFragmentAction, EventDetailsFragmentContract.EventDetailsFragmentDto> {

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var mPresenter: EventDetailsFragmentPresenter
    val presenter: EventDetailsFragmentPresenter get() = mPresenter

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

    override fun initView() {
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

    override fun sendActionAndData(action: EventDetailsFragmentAction?,
                                   data: EventDetailsFragmentContract.EventDetailsFragmentDto?) {
        presenter.consumeActionAndData(action, data)
    }

    override fun updateToolbar() {
        (activity as RootGodlikeActivity).prepareEventDetailsToolbar()
    }

    override fun handleInitialAction() {
        when (initialAction as EventDetailsFragmentAction?) {

            else -> {
            }
        }
    }

}