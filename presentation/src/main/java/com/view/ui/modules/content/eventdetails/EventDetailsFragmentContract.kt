package com.view.ui.modules.content.eventdetails

import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.base.presenter.BaseFragmentPresenter
import com.view.base.presenter.BasePresenterContract
import com.view.base.view.BaseView
import com.view.ui.modules.content.eventdetails.configurator.EventDetailsFragmentAction
import com.view.ui.modules.content.eventdetails.configurator.EventDetailsFragmentConfigurator


interface EventDetailsFragmentContract : BasePresenterContract {

    data class EventDetailsFragmentDto(var dummy: Boolean)

    interface EventDetailsFragmentView : BaseView {

        fun getViewData(): EventDetailsFragmentDto

    }

    abstract class EventDetailsFragmentPresenter : BaseFragmentPresenter<EventDetailsFragmentConfigurator, EventDetailsFragmentAction, EventDetailsFragmentView>() {
        init {
            this.intiConfigurator()
        }
    }

    abstract class EventDetailsFragment : PresenterFragment<EventDetailsFragmentPresenter>(), EventDetailsFragmentView, ActionProducer<EventDetailsFragmentAction> {

        override fun initView() {
            attachView()
        }

        private fun attachView() {
            this.presenter.attachView(this)
        }
    }
}