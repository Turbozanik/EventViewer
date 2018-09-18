package com.dagger.module

import com.dagger.scoupe.ActivityScope
import com.watchers.keepers.UserKeeper
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

	@Provides
	@ActivityScope
	fun provideUserKeeper(): UserKeeper = UserKeeper()

}