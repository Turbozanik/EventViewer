package com.view.ui.modules.profile.userprofile

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.view.R
import com.view.ui.godlikeroot.RootGodlikeActivity
import com.view.ui.modules.content.eventlist.adapter.EventListAdapter
import com.view.ui.modules.profile.userprofile.configurator.UserProfileFragmentAction
import kotlinx.android.synthetic.main.fragment_event_list.*
import kotlinx.android.synthetic.main.fragment_user_profile.*


class UserProfileFragment : UserProfileFragmentContract.UserProfileFragment() {

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var mPresenter: UserProfilePresenter
    val presenter: UserProfilePresenter get() = mPresenter
    private lateinit var mAdapter: EventListAdapter

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
        (activity as RootGodlikeActivity).prepareUserProfileToolbar()
    }

    override fun handleInitialAction() {
        when (initialAction as UserProfileFragmentAction) {

            else -> {

            }
        }
    }

    override fun initView() {
        initAdapter()
    }

    private fun initAdapter() {
        mAdapter = EventListAdapter()
    }

    override fun sendActionAndData(action: UserProfileFragmentAction?,
                                   data: UserProfileFragmentContract.UserProfileFragmentDto?) {
        presenter.consumeActionAndData(action, data)
    }

    override fun showProgress() {
        if (mEventListSwipeRefresh.setProgress(true)) return
        if (mAdapter.setProgress(true, mRvUsersEventList)) return
        super.showProgress()
    }

    override fun hideProgress() {
        if (mEventListSwipeRefresh.setProgress(false)) return
        if (mAdapter.setProgress(false, mRvUsersEventList)) return
        super.showProgress()
    }

}