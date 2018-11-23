package com.view.ui.modules.profile.userprofile

import com.domain.models.UserDto
import com.view.base.view.BaseView


interface UserProfileFragmentView : BaseView {

    fun populateProfileData(user: UserDto?)

}