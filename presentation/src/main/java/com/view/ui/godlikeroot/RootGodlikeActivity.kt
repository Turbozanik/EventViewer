package com.view.ui.godlikeroot

import android.content.res.Configuration
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.AUTH_SCREEN
import com.ActivityAction
import com.ActivityAction.DEFAULT
import com.EventViewerApp
import com.view.R
import com.view.base.activity.BaseActivity
import com.view.base.view.HasProgress
import com.view.ui.modules.auth.AuthModuleNavigator
import com.view.ui.modules.auth.REGISTRATION_SCREEN
import kotlinx.android.synthetic.main.activity_root.*
import kotlinx.android.synthetic.main.activity_root_content.*
import kotlinx.android.synthetic.main.activity_root_with_toolbar.*
import ru.terrakok.cicerone.Navigator

class RootGodlikeActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, HasProgress {

    private val mNavigator = object : FragmentNavigator(supportFragmentManager,
                                                        fragmentContainerViewId) {
        override fun createFragment(screenKey: String?, data: Any?): Fragment {
            return when (screenKey) {
                AUTH_SCREEN -> {
                    mAuthModuleHolder.createFragment(screenKey, null, activityInitAction)
                }
                REGISTRATION_SCREEN -> {
                    mAuthModuleHolder.createFragment(screenKey, null, activityInitAction)
                }
                else -> {
                    mAuthModuleHolder.createFragment(screenKey, null, activityInitAction)
                }
            }
        }
    }

    private lateinit var mToggle: ActionBarDrawerToggle
    private var mAuthModuleHolder: AuthModuleNavigator = AuthModuleNavigator(this,
                                                                             fragmentContainerViewId)
    override val navigator: Navigator
        get() = mNavigator

    override fun initView() {
        setSupportActionBar(mToolbar)

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
        menuInflater.inflate(R.menu.root_activity_menu, menu)
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
        get() = R.layout.activity_root

    override val fragmentContainerViewId: Int
        get() = R.id.mFragmentContainer

    val authModuleNavigatorNavigator: AuthModuleNavigator
        get() = mAuthModuleHolder

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

    override fun saveCurrentFragment(fragment: Fragment) {
        mCurrentFragment = fragment
    }

    fun prepareUserProfileToolbar() {
        mToolbar.title = getString(R.string.profile)
    }

    public fun showEventListFragment() {

    }

}