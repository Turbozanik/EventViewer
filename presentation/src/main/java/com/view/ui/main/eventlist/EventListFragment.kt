package com.view.ui.main.eventlist

import android.os.Bundle
import android.support.v4.app.Fragment
import com.FRAGMENT_DATA_KEY
import com.view.R
import com.view.ui.main.MainActivity
import com.view.ui.main.eventlist.adapter.EventListAdapter
import com.view.ui.main.eventlist.configurator.EventListFragmentAction
import kotlinx.android.synthetic.main.fragment_event_list.*
import javax.inject.Inject

class EventListFragment : EventListFragmentContract.EventListFragment() {

    @Inject
    protected lateinit var mFragmentPresenter: EventListFragmentPresenter
    private lateinit var mAdapter: EventListAdapter

    companion object {
        fun createNewInstance(): EventListFragment {
            return EventListFragment()
        }

        fun addInitialAction(fragment: Fragment, initialAction: EventListFragmentAction) {
            val args = Bundle()
            args.putSerializable(FRAGMENT_DATA_KEY, initialAction)
            fragment.arguments = args
        }
    }

    override val presenter: EventListFragmentContract.EventListPresenter
        get() = mFragmentPresenter

    override fun inject() {
        daggerController.eventListFragmentSubComponent?.inject(this)
    }

    override fun initView() {
        super.initView()
        initAdapter()
        mRvEventList.adapter = mAdapter
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
        mFragmentPresenter.consumeAction(action)
    }

    private fun initAdapter() {
        mAdapter = EventListAdapter()
    }

    override fun updateToolbar() {
        (activity as MainActivity).prepareEventListToolbar()
    }

    override fun handleInitialAction() {
        when (initialAction as EventListFragmentAction?) {

            else -> {
            }
        }
    }

}