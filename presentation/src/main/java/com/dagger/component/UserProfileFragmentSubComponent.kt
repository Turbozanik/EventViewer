package com.dagger.component

import com.dagger.module.UserProfileFragmentModule
import com.dagger.scoupe.UserProfileFragmentScope
import com.view.ui.profile.userprofile.UserProfileFragment
import dagger.Subcomponent


@UserProfileFragmentScope
@Subcomponent(modules = [UserProfileFragmentModule::class])
interface UserProfileFragmentSubComponent {

    fun inject(userProfileFragment: UserProfileFragment)

}