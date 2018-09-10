package com.view.ui.auth

import android.support.v4.app.Fragment
import android.view.View
import com.ActivityAction
import com.view.R
import com.view.base.activity.BaseActivity
import com.view.base.view.HasProgress
import com.view.ui.auth.login.LoginFragment
import com.view.ui.auth.login.configurator.LoginFragmentAction
import com.view.ui.auth.register.RegistrationFragment
import com.view.ui.auth.register.configurator.RegistrationFragmentAction
import kotlinx.android.synthetic.main.activity_login.*
import ru.terrakok.cicerone.Navigator

class AuthActivity : BaseActivity(), HasProgress {

    override val layoutId: Int
        get() = R.layout.activity_login
    override val navigator: Navigator
        get() {
            mNavigator = object : FragmentNavigator(supportFragmentManager,
                                                    fragmentContainerViewId) {
                override fun createFragment(screenKey: String?, data: Any?): Fragment {
                    val fragment: Fragment
                    when (screenKey) {
                        AuthActivityScreens.REGISTRATION_SCREEN -> {
                            fragment = RegistrationFragment.createNewInstance()
                            if (activityInitAction === com.ActivityAction.INITIAL_ACTION_DEFAULT) {
                                RegistrationFragment.addInitialAction(fragment,
                                                                      RegistrationFragmentAction.INITIAL_ACTION_DEFAULT)
                            }
                            return fragment
                        }
                        AuthActivityScreens.LOGIN_SCREEN -> {
                            fragment = LoginFragment.createNewInstance()
                            if (activityInitAction === com.ActivityAction.INITIAL_ACTION_DEFAULT) {
                                LoginFragment.addInitialAction(fragment,
                                                               LoginFragmentAction.INITIAL_ACTION_DEFAULT)
                            }
                            return fragment
                        }
                        else -> {
                            throw IllegalArgumentException(Throwable("Unknown screen"))
                        }
                    }
                }
            }
            return mNavigator
        }
    override val fragmentContainerViewId: Int
        get() = R.id.mAuthFragmentContainer

    override fun addActivitySubComponent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addCurrentActivitySubComponent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRootScreenKey(activityAction: ActivityAction?): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeCurrentSubComponent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
