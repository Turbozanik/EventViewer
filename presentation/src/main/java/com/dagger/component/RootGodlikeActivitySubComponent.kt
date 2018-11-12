package com.dagger.component

import com.dagger.module.*
import com.dagger.scoupe.RootGodlikeActivityScope
import com.view.ui.godlikeroot.RootGodlikeActivityPresenter
import dagger.Subcomponent

@RootGodlikeActivityScope
@Subcomponent(modules = [RootGodlikeActivityModule::class])
interface RootGodlikeActivitySubComponent {

    fun add(registrationModule: RegistrationFragmentModule): RegistrationFragmentSubComponent

    fun add(loginFragmentModule: LoginFragmentModule): LoginFragmentSubComponent

    fun add(eventListFragmentModule: EventListFragmentModule): EventListFragmentSubComponent

    fun add(eventDetailsFragmentModule: EventDetailsFragmentModule): EventDetailsFragmentSubComponent

    fun add(userProfileFragmentModule: UserProfileFragmentModule): UserProfileFragmentSubComponent

    fun inject(rootActivityPresenter: RootGodlikeActivityPresenter)

}