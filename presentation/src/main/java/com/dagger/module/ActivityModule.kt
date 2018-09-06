package com.dagger.module

import com.dagger.scoupe.ActivityScope
import com.watchers.keepers.UserKeeper
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @ActivityScope
    @Provides
    fun provideUserKeeper(): UserKeeper = UserKeeper()

}