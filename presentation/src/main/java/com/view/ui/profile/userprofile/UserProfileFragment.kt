package com.view.ui.profile.userprofile

import com.view.R
import com.view.ui.main.EventListActivity
import com.view.ui.profile.userprofile.configurator.UserProfileFragmentAction
import javax.inject.Inject


class UserProfileFragment : UserProfileFragmentContract.UserProfileFragment() {

    @Inject
    lateinit var mPresenter: UserProfileFragmentPresenter

    override val presenter: UserProfileFragmentContract.UserProfileFragmentPresenter
        get() = mPresenter

    override fun inject() {
        daggerController.userProfileFragmentSubComponent?.inject(this)
    }

    override fun addCurrentSubComponent() {
        daggerController.addUserProfileFragmentSubComponent()
    }

    override fun removeCurrentSubComponent() {
        daggerController.removeUserProfileFragmentSubComponent()
    }

    override val layoutId: Int
        get() = R.layout.fragment_user_profile

    override fun updateToolbar() {
        (activity as EventListActivity).prepareUserProfileToolbar()
    }

    override fun handleInitialAction() {
        when (initialAction as UserProfileFragmentAction) {

            else -> {

            }
        }
    }

    override fun sendAction(action: UserProfileFragmentAction?) {
        presenter.consumeAction(action)
    }

    override fun getViewData(): UserProfileFragmentContract.UserProfileFragmentDto {
        return UserProfileFragmentContract.UserProfileFragmentDto(
                UserProfileFragmentContract.UserProfileInfo("",
                                                            ""))
    }
}