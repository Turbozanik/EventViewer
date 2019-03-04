package com.dagger.component

import com.dagger.module.UserProfileFragmentModule
import com.dagger.scoupe.UserProfileFragmentScope
import com.view.ui.modules.profile.userprofile.UserProfileFragmentPresenter
import dagger.Subcomponent


@UserProfileFragmentScope
@Subcomponent(modules = [UserProfileFragmentModule::class])
interface UserProfileFragmentSubComponent {

    fun inject(userProfilePresenter: UserProfileFragmentPresenter)

}