package com.dagger.component

import com.dagger.module.EventListFragmentModule
import com.dagger.scoupe.EventListFragmentScope
import com.view.ui.modules.content.eventlist.EventListPresenter
import dagger.Subcomponent

@EventListFragmentScope
@Subcomponent(modules = [EventListFragmentModule::class])
interface EventListFragmentSubComponent {

    fun inject(eventListPresenter: EventListPresenter)

}