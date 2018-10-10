package com.view.ui.auth

import android.support.v4.app.Fragment
import android.view.View
import com.ActivityAction
import com.BACK_CONTENT_DESCRIPTOR
import com.view.R
import com.view.base.activity.BaseActivity
import com.view.base.view.HasProgress
import com.view.ui.auth.login.LoginFragment
import com.view.ui.auth.login.configurator.LoginFragmentAction
import com.view.ui.auth.register.RegistrationFragment
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.content_auth.*
import ru.terrakok.cicerone.Navigator

class AuthActivity : BaseActivity(), HasProgress {

    override val layoutId: Int
        get() = R.layout.activity_auth

    override val navigator: Navigator
        get() {
            mNavigator = object : FragmentNavigator(supportFragmentManager,
                                                    fragmentContainerViewId) {
                override fun createFragment(screenKey: String?, data: Any?): Fragment {
                    val fragment: Fragment
                    when (screenKey) {
                        LOGIN_SCREEN -> {
                            fragment = LoginFragment.createNewInstance()
                            if (activityInitAction == com.ActivityAction.OPEN_AUTH_ACTIVITY_WITH_NO_SAVED_CREDENTIALS) {
                                LoginFragment.addInitialAction(fragment,
                                                               LoginFragmentAction.DEFAULT)
                            }
                        }
                        REGISTRATION_SCREEN -> {
                            fragment = RegistrationFragment.createNewInstance()
                            LoginFragment.addInitialAction(fragment, LoginFragmentAction.DEFAULT)
                        }
                        else -> {
                            fragment = LoginFragment.createNewInstance()
                            LoginFragment.addInitialAction(fragment, LoginFragmentAction.DEFAULT)
                        }
                    }
                    saveCurrentFragment(fragment, screenKey)
                    return fragment
                }
            }
            return mNavigator
        }

    override fun initView() {
        setSupportActionBar(mToolbar)
    }

    override val fragmentContainerViewId: Int
        get() = R.id.mAuthFragmentContainer

    override fun addActivitySubComponent() {
        daggerController.addActivitySubComponent()
    }

    override fun addCurrentActivitySubComponent() {
        daggerController.addAuthActivitySubComponent()
    }

    override fun removeCurrentSubComponent() {
        daggerController.removeAuthActivitySubComponent()
    }

    override fun getRootScreenKey(activityAction: ActivityAction?): String {
        return when (activityAction) {
            ActivityAction.OPEN_AUTH_ACTIVITY_WITH_NO_SAVED_CREDENTIALS -> {
                LOGIN_SCREEN
            }
            else -> {
                LOGIN_SCREEN
            }
        }
    }

    override fun saveCurrentFragment(fragment: Fragment, screenKey: String?) {
        mCurrentFragment = fragment
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

    fun showRegistrationFragment(data: Any?) {
        addFragment(REGISTRATION_SCREEN, data)
    }

    fun goToMainActivityEventListFragment() {
        activityNavigator.startActivityWithInitialAction(
                ActivityAction.OPEN_MAIN_ACTIVITY_WITH_EVENT_LIST_FRAGMENT)
    }

    fun prepareRegistrationToolbar() {
        mToolbar?.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        mToolbar?.navigationContentDescription = BACK_CONTENT_DESCRIPTOR
        mToolbar?.title = getString(R.string.registration)
        mToolbar?.setNavigationOnClickListener {
            mToolbar?.navigationIcon = null
            goToPreviousFragment(LOGIN_SCREEN)
        }
    }

    fun prepareLoginToolbar() {
        mToolbar?.navigationIcon = null
        mToolbar?.title = getString(R.string.login)
    }

}
