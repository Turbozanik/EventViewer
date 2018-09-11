package com.view.ui.main

import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.ActivityAction
import com.EventViewerApp
import com.view.R
import com.view.base.activity.BaseActivity
import com.view.base.view.HasProgress
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import ru.terrakok.cicerone.Navigator

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, HasProgress {

    private lateinit var mToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        menuInflater.inflate(R.menu.main2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        mToggle.onConfigurationChanged(newConfig)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
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
//        return when (activityAction) {
//            AuthActivityAction.NOT_LOGGED_IN -> {
//                MainActivityScreens.REGISTRATION_SCREEN
//            }
//            else -> {
//                MainActivityScreens.REGISTRATION_SCREEN
//            }
//        }
        return ""
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
                    when (screenKey) {
//                        MainActivityScreens.REGISTRATION_SCREEN -> {
//                            val fragment = RegistrationFragment.createNewInstance()
//                            if (activityInitAction === com.AuthActivityAction.NOT_LOGGED_IN) {
//                                RegistrationFragment.addInitialAction(fragment,
//                                                                      RegistrationFragmentAction.INITIAL_ACTION_DEFAULT)
//                            }
//                            return fragment
//                        }
//                        else -> {
//                            throw IllegalArgumentException(Throwable("Unknown screen"))
//                        }
                    }
                    return Fragment()
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

}
