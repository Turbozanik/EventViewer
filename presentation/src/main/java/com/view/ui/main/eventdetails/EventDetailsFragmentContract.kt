package com.view.ui.main.eventdetails

import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.base.presenter.BaseFragmentPresenter
import com.view.base.presenter.BasePresenterContract
import com.view.base.view.BaseView
import com.view.ui.main.eventdetails.configurator.EventDetailsFragmentAction
import com.view.ui.main.eventdetails.configurator.EventDetailsFragmentConfigurator


interface EventDetailsFragmentContract : BasePresenterContract {

    data class EventDetailsFragmentDto(var dummy: Boolean)

    interface EventDetailsFragmentView : BaseView {

        fun getViewData(): EventDetailsFragmentContract.EventDetailsFragmentDto

    }

    abstract class EventDetailsFragmentPresenter : BaseFragmentPresenter<EventDetailsFragmentConfigurator, EventDetailsFragmentAction, EventDetailsFragmentContract.EventDetailsFragmentView>() {
        init {
            this.intiConfigurator()
        }
    }

    abstract class EventDetailsFragment : PresenterFragment<EventDetailsFragmentContract.EventDetailsFragmentPresenter>(), EventDetailsFragmentContract.EventDetailsFragmentView, ActionProducer<EventDetailsFragmentAction> {

        override fun initView() {
            attachView()
        }

        private fun attachView() {
            this.presenter.attachView(this)
        }
    }
}