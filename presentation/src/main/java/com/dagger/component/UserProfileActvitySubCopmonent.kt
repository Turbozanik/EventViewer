package com.dagger.component

import com.dagger.module.UserProfileActivityModle
import com.dagger.module.UserProfileFragmentModule
import com.dagger.scoupe.UserProfileActivityScope
import dagger.Subcomponent

@UserProfileActivityScope
@Subcomponent(modules = [UserProfileActivityModle::class])
interface UserProfileActvitySubCopmonent {

    fun add(userProfileFragmentModule: UserProfileFragmentModule): UserProfileFragmentSubComponent

}