package com.dagger.component

import com.dagger.module.LoginFragmentModule
import com.dagger.scoupe.LoginFragmentScope
import com.view.ui.auth.login.LoginFragment
import dagger.Subcomponent


@LoginFragmentScope
@Subcomponent(modules = [LoginFragmentModule::class])
interface LoginFragmentSubComponent {

	fun inject(loginFragment: LoginFragment)

}