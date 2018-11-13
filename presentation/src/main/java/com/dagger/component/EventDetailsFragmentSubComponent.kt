package com.dagger.component

import com.dagger.module.EventDetailsFragmentModule
import com.dagger.scoupe.EventDetailsFragmentScope
import com.view.ui.modules.content.eventdetails.EventDetailsPresenter
import dagger.Subcomponent

@EventDetailsFragmentScope
@Subcomponent(modules = [EventDetailsFragmentModule::class])
interface EventDetailsFragmentSubComponent {

    fun inject(eventDetailsPresenter: EventDetailsPresenter)

}