package com.view.ui.modules.profile.userprofile

import com.view.base.BasePresenter
import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.base.fragment.presenter.BasePresenterContract
import com.view.ui.modules.profile.userprofile.configurator.UserProfileFragmentAction
import com.view.ui.modules.profile.userprofile.configurator.UserProfileFragmentConfigurator

interface UserProfileFragmentContract : BasePresenterContract {

    data class UserProfileInfo(var email: String, var password: String)

    data class UserProfileFragmentDto(var userProfileInfo: UserProfileInfo)

    abstract class UserProfilePresenter : BasePresenter<UserProfileFragmentConfigurator, UserProfileFragmentAction, UserProfileFragmentDto, UserProfileFragmentView>() {
        init {
            this.intiConfigurator()
        }
    }

    abstract class UserProfileFragment : PresenterFragment(), ActionProducer<UserProfileFragmentAction, UserProfileFragmentDto>, UserProfileFragmentView

}