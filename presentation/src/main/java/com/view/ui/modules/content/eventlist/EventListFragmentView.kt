package com.view.ui.modules.content.eventlist

import com.view.base.view.BaseView


interface EventListFragmentView : BaseView {

    fun onMoreEventsLoaded()

    fun onEventsReloaded()

}