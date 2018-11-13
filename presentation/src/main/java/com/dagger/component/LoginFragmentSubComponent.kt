package com.dagger.component

import com.dagger.module.LoginFragmentModule
import com.dagger.scoupe.LoginFragmentScope
import com.view.ui.modules.auth.login.LoginPresenter
import dagger.Subcomponent


@LoginFragmentScope
@Subcomponent(modules = [LoginFragmentModule::class])
interface LoginFragmentSubComponent {

    fun inject(loginPresenter: LoginPresenter)

}