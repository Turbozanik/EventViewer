package com.dagger.component

import com.dagger.module.MainActivityModule
import com.dagger.module.RegistrationFragmentModule
import com.dagger.scoupe.MainActivityScope
import dagger.Subcomponent

@MainActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivitySubComponent {

    fun add(registrationModule: RegistrationFragmentModule): RegistrationFragmentSubComponent

}