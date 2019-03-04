package com.dagger.component

import com.dagger.module.ActivityModule
import com.dagger.module.NetModule
import com.dagger.module.RootGodlikeActivityModule
import com.dagger.scoupe.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class, NetModule::class])
interface ActivitySubComponent {

    fun add(rootGodlikeActivityModule: RootGodlikeActivityModule): RootGodlikeActivitySubComponent

}