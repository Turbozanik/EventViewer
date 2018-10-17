package com.dagger.component

import com.dagger.module.*
import com.dagger.scoupe.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class, NetModule::class])
interface ActivitySubComponent {

    fun add(splashActivityModule: SplashActivityModule): SplashActivitySubComponent

    fun add(authActivityModule: AuthActivityModule): AuthActivitySubComponent

    fun add(mainActivityModule: MainActivityModule): MainActivitySubComponent

    fun add(userProfileActivityModle: UserProfileActivityModle): UserProfileActvitySubCopmonent

}