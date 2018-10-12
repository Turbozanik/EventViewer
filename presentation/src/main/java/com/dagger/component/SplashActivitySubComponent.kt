package com.dagger.component

import com.dagger.module.SplashActivityModule
import com.dagger.scoupe.SplashActivityScope
import com.view.ui.splash.SplashActivity
import dagger.Subcomponent


@SplashActivityScope
@Subcomponent(modules = [SplashActivityModule::class])
interface SplashActivitySubComponent {
    fun inject(plashActivity: SplashActivity)
}