package com.dagger.component

import com.dagger.module.ActivityModule
import com.dagger.module.AuthActivityModule
import com.dagger.module.MainActivityModule
import com.dagger.module.NetModule
import com.dagger.scoupe.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class, NetModule::class])
interface ActivitySubComponent {

	fun add(mainActivityModule: MainActivityModule): MainActivitySubComponent

	fun add(authActivityModule: AuthActivityModule): AuthActivitySubComponent

}