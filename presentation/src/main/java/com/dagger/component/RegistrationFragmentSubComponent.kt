package com.dagger.component

import com.dagger.module.RegistrationFragmentModule
import com.dagger.scoupe.RegistrationFragmentScope
import com.view.ui.auth.register.RegistrationFragment
import dagger.Subcomponent


@RegistrationFragmentScope
@Subcomponent(modules = [RegistrationFragmentModule::class])
interface RegistrationFragmentSubComponent {

	fun inject(registrationFragment: RegistrationFragment)

}