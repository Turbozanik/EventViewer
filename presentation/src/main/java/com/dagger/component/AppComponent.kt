package com.dagger.component

import com.dagger.module.ActivityModule
import com.dagger.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun add(activityModule: ActivityModule): ActivitySubComponent
}