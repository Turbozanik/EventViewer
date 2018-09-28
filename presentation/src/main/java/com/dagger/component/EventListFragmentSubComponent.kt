package com.dagger.component

import com.dagger.module.EventListFragmentModule
import com.dagger.scoupe.EventListFragmentScope
import com.view.ui.main.eventlist.EventListFragment
import dagger.Subcomponent

@EventListFragmentScope
@Subcomponent(modules = [EventListFragmentModule::class])
interface EventListFragmentSubComponent {

    fun inject(eventListFragment: EventListFragment)

}