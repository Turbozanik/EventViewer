package com.view.ui.modules.profile.userprofile

import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.base.presenter.BaseFragmentPresenter
import com.view.base.presenter.BasePresenterContract
import com.view.base.view.BaseView
import com.view.ui.modules.profile.userprofile.configurator.UserProfileFragmentAction
import com.view.ui.modules.profile.userprofile.configurator.UserProfileFragmentConfigurator

interface UserProfileFragmentContract : BasePresenterContract {

    data class UserProfileInfo(var email: String, var password: String)

    data class UserProfileFragmentDto(var userProfileInfo: UserProfileInfo)

    interface UserProfileFragmentView : BaseView {

        fun getViewData(): UserProfileFragmentDto

    }

    abstract class UserProfileFragmentPresenter : BaseFragmentPresenter<UserProfileFragmentConfigurator, UserProfileFragmentAction, UserProfileFragmentView>()

    abstract class UserProfileFragment : PresenterFragment<UserProfileFragmentPresenter>(), ActionProducer<UserProfileFragmentAction>, UserProfileFragmentView {

        override fun initView() {
            attachView()
        }

        private fun attachView() {
            this.presenter.attachView(this)
        }
    }

}