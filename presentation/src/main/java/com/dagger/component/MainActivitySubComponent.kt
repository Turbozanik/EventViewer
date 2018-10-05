package com.dagger.component

import com.dagger.module.EventDetailsFragmentModule
import com.dagger.module.EventListFragmentModule
import com.dagger.module.MainActivityModule
import com.dagger.scoupe.MainActivityScope
import dagger.Subcomponent

@MainActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivitySubComponent {

    fun add(eventListFragmentModule: EventListFragmentModule): EventListFragmentSubComponent

    fun add(eventDetailsFragmentModule: EventDetailsFragmentModule): EventDetailsFragmentSubComponent

}