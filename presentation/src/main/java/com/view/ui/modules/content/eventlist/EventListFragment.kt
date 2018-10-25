package com.view.ui.modules.content.eventlist

import android.os.Bundle
import android.support.v4.app.Fragment
import com.FRAGMENT_DATA_KEY
import com.view.R
import com.view.base.view.OnScrolledToEndListener
import com.view.ui.godlikeroot.RootGodlikeActivity
import com.view.ui.modules.content.eventlist.adapter.EventListAdapter
import com.view.ui.modules.content.eventlist.configurator.EventListFragmentAction
import kotlinx.android.synthetic.main.fragment_event_list.*

class EventListFragment : EventListFragmentContract.EventListFragment() {

    override fun createPresenter(): EventListFragmentContract.EventListPresenter {
        return EventListFragmentPresenter()
    }

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

    override fun inject() {
        daggerController.eventListFragmentSubComponent?.inject(this)
    }

    override fun initView() {
        initAdapter()
        initRecyclerView()
        initSwipeRefreshLayout()
        (activity as RootGodlikeActivity).prepareEventListToolbar()
    }

    private fun initRecyclerView() {
        mRvEventList.adapter = mAdapter
        mRvEventList.addOnScrollListener(object : OnScrolledToEndListener(mEventListSwipeRefresh,
                                                                          mAdapter) {
            override fun onScrolledToEnd() {
                sendAction(EventListFragmentAction.LOAD_MORE_EVENTS)
            }
        })
    }

    private fun initSwipeRefreshLayout() {
        mEventListSwipeRefresh.setOnRefreshListener {
            sendAction(EventListFragmentAction.RELOAD_EVENTS)
        }
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
        presenter.consumeAction(action)
    }

    private fun initAdapter() {
        mAdapter = EventListAdapter()
    }

    override fun updateToolbar() {
        (activity as RootGodlikeActivity).prepareEventListToolbar()
    }

    override fun handleInitialAction() {
        when (initialAction as EventListFragmentAction?) {

            else -> {
            }
        }
    }

    override fun showProgress() {
        if (mEventListSwipeRefresh.setProgress(true)) return
        if (mAdapter.setProgress(true, mRvEventList)) return
        super.showProgress()
    }

    override fun hideProgress() {
        if (mEventListSwipeRefresh.setProgress(false)) return
        if (mAdapter.setProgress(false, mRvEventList)) return
        super.showProgress()
    }

    override fun onEventsReloaded() {
        hideProgress()
    }

    override fun onMoreEventsLoaded() {
        hideProgress()
    }

}