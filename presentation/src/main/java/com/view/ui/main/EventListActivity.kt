package com.view.ui.main

import android.content.res.Configuration
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import com.ActivityAction
import com.ActivityAction.DEFAULT
import com.EventViewerApp
import com.view.R
import com.view.base.activity.BaseActivity
import com.view.base.view.HasProgress
import com.view.ui.main.eventdetails.EventDetailsFragment
import com.view.ui.main.eventlist.EventListFragment
import com.view.ui.main.eventlist.configurator.EventListFragmentAction
import kotlinx.android.synthetic.main.activity_event_list.*
import kotlinx.android.synthetic.main.content_event_list.*
import ru.terrakok.cicerone.Navigator

class EventListActivity : BaseActivity(), HasProgress {

    private lateinit var mToggle: ActionBarDrawerToggle

    override fun initView() {
        setSupportActionBar(mToolbar)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        mToggle.onConfigurationChanged(newConfig)
    }

    override fun addActivitySubComponent() {
        daggerController.addActivitySubComponent()
    }

    override fun addCurrentActivitySubComponent() {
        daggerController.addMainActivitySubComponent()
    }

    override fun getScreenKeyByAction(activityAction: ActivityAction?): String {
        return when (activityAction) {
            DEFAULT -> EVENT_LIST_SCREEN
            null -> EVENT_LIST_SCREEN
            else -> {
                EVENT_LIST_SCREEN
            }
        }
    }

    override fun removeCurrentSubComponent() {
        EventViewerApp.getInstance().getDaggerController().removeActivitySubComponent()
    }

    override val layoutId: Int
        get() = R.layout.activity_event_list

    override val fragmentContainerViewId: Int
        get() = R.id.mFragmentContainer

    override val navigator: Navigator
        get() {
            mNavigator = object : FragmentNavigator(supportFragmentManager,
                                                    fragmentContainerViewId) {
                override fun createFragment(screenKey: String?, data: Any?): Fragment {
                    val fragment: Fragment
                    when (screenKey) {
                        EVENT_LIST_SCREEN -> {
                            fragment = EventListFragment.createNewInstance()
                            if (activityInitAction == com.ActivityAction.OPEN_AUTH_ACTIVITY_WITH_NO_SAVED_CREDENTIALS) {
                                EventListFragment.addInitialAction(fragment,
                                                                   EventListFragmentAction.INITIAL_ACTION_DEFAULT)
                            }
                        }
                        EVENT_DETAILS_SCREEN -> {
                            fragment = EventDetailsFragment.createNewInstance()
                        }
                        else -> {
                            fragment = EventListFragment.createNewInstance()
                        }
                    }
                    saveCurrentFragment(fragment, screenKey)
                    return fragment
                }
            }
            return mNavigator
        }

    override fun showProgress() {
        progressView.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressView.visibility = View.GONE
    }

    override val progressView: View
        get() {
            return mProgressBar
        }

    fun prepareEventListToolbar() {
        mToolbar.title = getString(R.string.event_list)
    }

    fun prepareEventDetailsToolbar() {
        mToolbar.title = getString(R.string.event_details)
    }

    override fun saveCurrentFragment(fragment: Fragment, screenKey: String?) {
        mCurrentFragment = fragment
    }

    fun prepareUserProfileToolbar() {
        mToolbar.title = getString(R.string.profile)
    }

}
