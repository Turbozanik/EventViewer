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
import com.view.base.configurator.ActionProducer
import com.view.base.view.HasProgress
import com.view.ui.godlikeroot.configurator.RootActivityAction
import com.view.ui.modules.auth.AuthModuleFragmentFactory
import com.view.ui.modules.auth.REGISTRATION_SCREEN
import com.view.ui.modules.content.eventlist.EventListFragment
import com.view.ui.modules.content.organization.*
import com.view.ui.modules.profile.PROFILE_SCREEN
import com.view.ui.modules.profile.ProfileModuleFragmentFactory
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
                PROFILE_SCREEN -> {
                    mUserProfileFactory.createFragment(screenKey, null)
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
                ORGANIZATION_LIST_SCREEN -> {
                    mContentHolder.createFragment(screenKey, null)
                }
                ORGANIZATION_DETAILS_SCREEN -> {
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
    private var mUserProfileFactory: ProfileModuleFragmentFactory = ProfileModuleFragmentFactory()
    private var mContentHolder: ContentModuleFragmentFactory = ContentModuleFragmentFactory()
    override val navigator: Navigator
        get() = mNavigator

    override fun initView() {
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        mToggle = ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                com.view.R.string.navigation_drawer_open,
                com.view.R.string.navigation_drawer_close)
        mDrawerLayout.addDrawerListener(mToggle)
        mToggle.syncState()

        mNavView.setNavigationItemSelectedListener(this)
        initBackStackListener()
    }

    private fun initBackStackListener() {
        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount > 0) {
                mToggle.isDrawerIndicatorEnabled = false
                supportActionBar?.setDisplayHomeAsUpEnabled(true)// show back button
                mToolbar.setNavigationOnClickListener { onBackPressed() }
                setEvenListSelected()
            } else {
                mToggle.isDrawerIndicatorEnabled = true
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                mToggle.syncState()
                mToolbar.setNavigationOnClickListener {
                    mDrawerLayout.openDrawer(GravityCompat.START)
                }
            }
        }
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
        menuInflater.inflate(com.view.R.menu.root_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            com.view.R.id.action_settings -> true
            com.view.R.id.home -> {
                onBackPressed()
                true
            }
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
            com.view.R.id.all -> {
                sendActionAndData(RootActivityAction.EVENT_LIST_ITEM_CLICK, null)
            }
            com.view.R.id.nav_gallery -> {
                sendActionAndData(RootActivityAction.CONFERENCE_ITEM_CLICK, null)
            }
            com.view.R.id.nav_user_profile -> {
                sendActionAndData(RootActivityAction.USER_PROFILE_CLICK, null)
            }
            com.view.R.id.nav_manage -> {
                sendActionAndData(RootActivityAction.COMPANY_DETAILS_CLICK, null)
            }
            com.view.R.id.nav_share -> {
                sendActionAndData(RootActivityAction.COMPANY_LIST_CLICK, null)
            }
            com.view.R.id.nav_send -> {

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
        get() = com.view.R.layout.activity_root

    override val fragmentContainerViewId: Int
        get() = com.view.R.id.mFragmentContainer

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
        mToolbar.title = getString(com.view.R.string.all)
    }

    fun prepareEventDetailsToolbar() {
        mToolbar.title = getString(com.view.R.string.event_details)
    }

    fun prepareRegistrationFragmentToolbar() {
        mToolbar.title = getString(com.view.R.string.registration)
    }

    fun prepareLoginToolbar() {
        mToolbar.title = getString(com.view.R.string.login)
    }

    fun prepareUserProfileToolbar() {
        mToolbar.title = getString(com.view.R.string.profile)
    }

    fun prepareOrganizationFragmentToolbar() {
        mToolbar.title = getString(com.view.R.string.orgagizations)
    }

    fun prepareOrganizationListFragmentToolbar() {
        mToolbar.title = getString(com.view.R.string.organization_list)
    }

    fun addRegistrationFragment(data: Bundle?) {
        addFragment(REGISTRATION_SCREEN, data)
    }

    fun addUserProfileFragment(data: Bundle?) {
        addFragment(PROFILE_SCREEN, data)
    }

    fun addCompanyDetailsFragment(data: Bundle?) {
        addFragment(ORGANIZATION_DETAILS_SCREEN, data)
    }

    private fun showEventListFragmentRoot(data: Bundle?) {
        showRootScreen(EVENT_LIST_SCREEN, data)
    }

    override fun goToProfileFragment() {
        mNavView.setCheckedItem(com.view.R.id.nav_user_profile)
        addUserProfileFragment(null)
    }

    override fun goToEventListFragment() {
        setEvenListSelected()
        showEventListFragmentRoot(null)
    }

    override fun goToConferenceFragment() {
        addRegistrationFragment(null)
    }

    override fun goToCompanyDetailsFragment() {
        addCompanyDetailsFragment(null)
    }

    override fun goToCompanyListFragment() {
        mNavView.setCheckedItem(com.view.R.id.nav_share)
        addCompanyListFragment(null)
    }

    private fun addCompanyListFragment(bundle: Bundle?) {
        addFragment(ORGANIZATION_LIST_SCREEN, bundle)
    }

    private fun setEvenListSelected() {
        mNavView.setCheckedItem(com.view.R.id.all)
    }

    override fun goBack() {
        when {
            currentFragment is EventListFragment -> moveTaskToBack(true)
            fragmentManager.backStackEntryCount > 2 -> goToPreviousFragment()
            else -> {
                goToPreviousFragment()
            }
        }
    }

}
