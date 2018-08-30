package com.dagger.component

import com.dagger.module.ActivityModule
import com.dagger.module.AppModule
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [AppModule::class])
interface AppComponent {
    fun add(activityModule: ActivityModule): ActivitySubComponent
}