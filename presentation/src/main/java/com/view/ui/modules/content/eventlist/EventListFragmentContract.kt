package com.view.ui.modules.content.eventlist

import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.base.presenter.BaseFragmentPresenter
import com.view.base.presenter.BasePresenterContract
import com.view.base.view.BaseView
import com.view.ui.modules.content.eventlist.configurator.EventListFragmentAction
import com.view.ui.modules.content.eventlist.configurator.EventListFragmentConfigurator

interface EventListFragmentContract : BasePresenterContract {

    data class EventListFragmentDto(var dummy: Boolean)

    interface EventListFragmentView : BaseView {

        fun getViewData(): EventListFragmentDto

    }

    abstract class EventListPresenter : BaseFragmentPresenter<EventListFragmentConfigurator, EventListFragmentAction, EventListFragmentView>() {
        init {
            this.intiConfigurator()
        }
    }

    abstract class EventListFragment : PresenterFragment<EventListPresenter>(), EventListFragmentView, ActionProducer<EventListFragmentAction> {

        override fun initView() {
            attachView()
        }

        private fun attachView() {
            this.presenter.attachView(this)
        }
    }

}