package com.view.ui.modules.content.eventlist

import com.view.base.BasePresenter
import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.base.fragment.presenter.BasePresenterContract
import com.view.ui.modules.content.eventlist.configurator.EventListFragmentAction
import com.view.ui.modules.content.eventlist.configurator.EventListFragmentConfigurator

interface EventListFragmentContract : BasePresenterContract {

    data class EventListFragmentDto(var dummy: Boolean)

    abstract class EventListPresenter : BasePresenter<EventListFragmentConfigurator, EventListFragmentAction, EventListFragmentDto, EventListFragmentView>() {
        init {
            this.intiConfigurator()
            this.injectPresenter()
        }
    }

    abstract class EventListFragment : PresenterFragment(), EventListFragmentView, ActionProducer<EventListFragmentAction, EventListFragmentDto>

}