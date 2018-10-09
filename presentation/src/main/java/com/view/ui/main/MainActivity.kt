package com.view.ui.main

import android.content.res.Configuration
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.ActivityAction
import com.ActivityAction.*
import com.EventViewerApp
import com.view.R
import com.view.base.activity.BaseActivity
import com.view.base.view.HasProgress
import com.view.ui.auth.login.LoginFragment
import com.view.ui.auth.login.configurator.LoginFragmentAction
import com.view.ui.main.eventdetails.EventDetailsFragment
import com.view.ui.main.eventlist.EventListFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import ru.terrakok.cicerone.Navigator

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, HasProgress {

    private lateinit var mToggle: ActionBarDrawerToggle

    override fun initView() {
        setSupportActionBar(mToolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        mToggle = ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
        mDrawerLayout.addDrawerListener(mToggle)
        mToggle.syncState()

        mNavView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        mToggle.onConfigurationChanged(newConfig)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.event_list -> {
                addFragment(EVENT_DETAILS_SCREEN, null)
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        mDrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun addActivitySubComponent() {
        daggerController.addActivitySubComponent()
    }

    override fun addCurrentActivitySubComponent() {
        daggerController.addMainActivitySubComponent()
    }

    override fun getRootScreenKey(activityAction: ActivityAction?): String {
        return when (activityAction) {
            DEFAULT -> TODO()
            OPEN_MAIN_ACTIVITY -> TODO()
            OPEN_AUTH_ACTIVITY -> TODO()
            OPEN_AUTH_ACTIVITY_WITH_NO_SAVED_CREDENTIALS -> TODO()
            OPEN_MAIN_ACTIVITY_WITH_EVENT_LIST_FRAGMENT -> EVENT_LIST_SCREEN
            null -> TODO()
        }
    }

    override fun removeCurrentSubComponent() {
        EventViewerApp.getInstance().getDaggerController().removeActivitySubComponent()
    }

    override val layoutId: Int
        get() = R.layout.activity_main

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
                                LoginFragment.addInitialAction(fragment,
                                                               LoginFragmentAction.DEFAULT)
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

}
