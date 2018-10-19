package com.dagger.component

import com.dagger.module.*
import com.dagger.scoupe.RootGodlikeActivityScope
import dagger.Subcomponent

@RootGodlikeActivityScope
@Subcomponent(modules = [RootGodlikeActivityModule::class])
interface RootGodlikeActivitySubComponent {

    //test
    fun add(registrationModule: RegistrationFragmentModule): RegistrationFragmentSubComponent

    fun add(loginFragmentModule: LoginFragmentModule): LoginFragmentSubComponent

    fun add(eventListFragmentModule: EventListFragmentModule): EventListFragmentSubComponent

    fun add(eventDetailsFragmentModule: EventDetailsFragmentModule): EventDetailsFragmentSubComponent

    fun add(userProfileFragmentModule: UserProfileFragmentModule): UserProfileFragmentSubComponent

}