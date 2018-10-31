package com.view.ui.modules.profile.userprofile

import com.view.base.presenter.BasePresenterContract

interface UserProfileFragmentContract : BasePresenterContract {

    data class UserProfileInfo(var email: String, var password: String)

    data class UserProfileFragmentDto(var userProfileInfo: UserProfileInfo)

//    interface UserProfileFragmentView : BaseView

//    abstract class UserProfileFragmentPresenter : BaseFragmentPresenter<UserProfileFragmentConfigurator, UserProfileFragmentAction, UserProfileFragmentDto, UserProfileFragmentView>(){
//        init {
//            this.intiConfigurator()
//        }
//    }
//
//    abstract class UserProfileFragment : PresenterFragment(), ActionProducer<UserProfileFragmentAction, UserProfileFragmentDto>, UserProfileFragmentView

}