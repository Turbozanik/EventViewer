package com.view.ui.main.eventlist

import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.base.presenter.BaseFragmentPresenter
import com.view.base.presenter.BasePresenterContract
import com.view.base.view.BaseView
import com.view.ui.main.eventlist.configurator.EventListFragmentAction
import com.view.ui.main.eventlist.configurator.EventListFragmentConfigurator

interface EventListFragmentContract : BasePresenterContract {

    data class EventListFragmentDto(var dummy: Boolean)

    interface EventListFragmentView : BaseView {

        fun getViewData(): EventListFragmentContract.EventListFragmentDto

    }

    abstract class EventListPresenter : BaseFragmentPresenter<EventListFragmentConfigurator, EventListFragmentAction, EventListFragmentContract.EventListFragmentView>() {
        init {
            this.intiConfigurator()
        }
    }

    abstract class EventListFragment : PresenterFragment<EventListFragmentContract.EventListPresenter>(), EventListFragmentContract.EventListFragmentView, ActionProducer<EventListFragmentAction> {

        override fun initView() {
            attachView()
        }

        private fun attachView() {
            this.presenter.attachView(this)
        }
    }

}