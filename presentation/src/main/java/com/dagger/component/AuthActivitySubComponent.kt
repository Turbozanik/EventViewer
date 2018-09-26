package com.dagger.component

import com.dagger.module.AuthActivityModule
import com.dagger.module.LoginFragmentModule
import com.dagger.module.RegistrationFragmentModule
import com.dagger.scoupe.AuthActivityScope
import dagger.Subcomponent

@AuthActivityScope
@Subcomponent(modules = [AuthActivityModule::class])
interface AuthActivitySubComponent {

    fun add(registrationModule: RegistrationFragmentModule): RegistrationFragmentSubComponent

    fun add(loginFragmentModule: LoginFragmentModule): LoginFragmentSubComponent

}