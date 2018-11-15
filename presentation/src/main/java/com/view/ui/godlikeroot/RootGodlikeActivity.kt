package com.view.ui.godlikeroot

import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.AUTH_SCREEN
import com.InitialAction
import com.InitialAction.DEFAULT
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.view.R
import com.view.base.configurator.ActionProducer
import com.view.base.view.HasProgress
import com.view.ui.godlikeroot.configurator.RootActivityAction
import com.view.ui.modules.auth.AuthModuleFragmentFactory
import com.view.ui.modules.auth.REGISTRATION_SCREEN
import com.view.ui.modules.auth.register.RegistrationFragment
import com.view.ui.modules.content.ContentFragmentFactory
import kotlinx.android.synthetic.main.activity_root.*
import kotlinx.android.synthetic.main.activity_root_content.*
import kotlinx.android.synthetic.main.activity_root_with_toolbar.*
import ru.terrakok.cicerone.Navigator


class RootGodlikeActivity : RootGodlikeActivityContract.RootActivity(), NavigationView.OnNavigationItemSelectedListener, HasProgress, ActionProducer<RootActivityAction, RootGodlikeActivityContract.RootActivityDto> {

    private val mNavigator = object : FragmentNavigator(supportFragmentManager,
                                                        fragmentContainerViewId) {
        override fun createFragment(screenKey: String?, data: Any?): Fragment {
            return when (screenKey) {
                AUTH_SCREEN -> {
                    mAuthModuleFragmentHolder.createFragment(screenKey, null)
                }
                REGISTRATION_SCREEN -> {
                    mAuthModuleFragmentHolder.createFragment(screenKey, null)
                }
                EVENT_LIST_SCREEN -> {
                    mContentHolder.createFragment(screenKey, null)
                }
                EVENT_LIST_WITH_SAVED_CREDENTIALS_SCREEN -> {
                    mContentHolder.createFragment(screenKey, null)
                }
                EVENT_DETAILS_SCREEN -> {
                    mContentHolder.createFragment(screenKey, null)
                }
                else -> {
                    mContentHolder.createFragment(EVENT_LIST_SCREEN, null)
                }
            }
        }
    }

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var mPresenter: RootGodlikeActivityPresenter
    private lateinit var mToggle: ActionBarDrawerToggle
    private var mAuthModuleFragmentHolder: AuthModuleFragmentFactory = AuthModuleFragmentFactory()
    private var mContentHolder: ContentFragmentFactory = ContentFragmentFactory()
    override val navigator: Navigator
        get() = mNavigator

    override fun initView() {
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        mToggle = ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                                        R.string.navigation_drawer_open,
                                        R.string.navigation_drawer_close)
        mDrawerLayout.addDrawerListener(mToggle)
        mToggle.syncState()

        mNavView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            sendActionAndData(RootActivityAction.BACK_CLICK, null)
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

    override fun sendActionAndData(action: RootActivityAction?,
                                   data: RootGodlikeActivityContract.RootActivityDto?) {
        mPresenter.consumeActionAndData(action, data)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.all -> {
                sendActionAndData(RootActivityAction.EVENT_LIST_ITEM_CLICK, null)
            }
            R.id.nav_gallery -> {
                sendActionAndData(RootActivityAction.CONFERENCE_ITEM_CLICK, null)
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
        daggerController.addRootActivitySubComponent()
    }

    override fun removeCurrentSubComponent() {
        daggerController.removeRootActivitySubComponent()
    }

    override fun getScreenKeyByAction(initialAction: InitialAction?): String {
        return when (initialAction) {
            DEFAULT -> EVENT_LIST_SCREEN
            null -> EVENT_LIST_SCREEN
            else -> {
                EVENT_LIST_SCREEN
            }
        }
    }

    override val layoutId: Int
        get() = R.layout.activity_root

    override val fragmentContainerViewId: Int
        get() = R.id.mFragmentContainer

    override fun showProgress() {
        progressView.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressView.visibility = View.GONE
    }

    override fun goToAuthFragment() {
        addFragment(EVENT_LIST_SCREEN, null)
    }

    override val progressView: View
        get() {
            return mProgressBar
        }

    override fun getDefaultInitialAction(): InitialAction {
        return DEFAULT
    }

    override fun handleInitialAction(initialAction: InitialAction) {
        sendActionAndData(RootActivityAction.DEFAULT, null)
    }

    fun prepareEventListToolbar() {
        mToolbar.title = getString(R.string.all)
    }

    fun prepareEventDetailsToolbar() {
        mToolbar.title = getString(R.string.event_details)
    }

    fun prepareRegistrationFragmentToolbar() {
        mToolbar.title = getString(R.string.registration)
    }

    fun prepareLoginToolbar() {
        mToolbar.title = getString(R.string.login)
    }

    fun prepareUserProfileToolbar() {
        mToolbar.title = getString(R.string.profile)
    }

    fun addRegistrationFragment(data: Bundle?) {
        addFragment(REGISTRATION_SCREEN, data)
    }

    private fun addEventListFragmentRoot(data: Bundle?) {
        showRootScreen(EVENT_LIST_SCREEN, data)
    }

    fun goToAllEventsScreen(data: Bundle?) {
        mNavView.setCheckedItem(R.id.all)
        onNavigationItemSelected(mNavView.menu.findItem(R.id.all))
    }

    override fun goToEventListFragment() {
        addEventListFragmentRoot(null)
    }

    override fun goToConferenceFragment() {
        addRegistrationFragment(null)
    }

    override fun goBack() {
        if (currentFragment is RegistrationFragment) {
            mNavView.setCheckedItem(R.id.all)
        }
        goToPreviousFragment()
    }

}
