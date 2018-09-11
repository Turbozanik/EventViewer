package com.view.ui.auth

import android.support.v4.app.Fragment
import android.view.View
import com.ActivityAction
import com.domain.usecase.prefs.user.GetUserEmailUseCase
import com.domain.usecase.prefs.user.GetUserPasswordUseCase
import com.view.R
import com.view.base.activity.BaseActivity
import com.view.base.view.HasProgress
import com.view.ui.auth.login.LoginFragment
import com.view.ui.auth.login.configurator.LoginFragmentAction
import kotlinx.android.synthetic.main.activity_login.*
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

class AuthActivity : BaseActivity(), HasProgress {

    @Inject
    lateinit var mGetUserPasswordUserCase: GetUserPasswordUseCase
    @Inject
    lateinit var mGetUserEmailUseCase: GetUserEmailUseCase

    override val layoutId: Int
        get() = R.layout.activity_login

    override val navigator: Navigator
        get() {
            mNavigator = object : FragmentNavigator(supportFragmentManager,
                                                    fragmentContainerViewId) {
                override fun createFragment(screenKey: String?, data: Any?): Fragment {
                    val fragment: Fragment
                    when (screenKey) {
                        AuthActivityScreens.LOGIN_SCREEN -> {
                            fragment = LoginFragment.createNewInstance()
                            if (activityInitAction == com.ActivityAction.NOT_LOGGED_IN) {
                                LoginFragment.addInitialAction(fragment,
                                                               LoginFragmentAction.DEFAULT)
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
            ActivityAction.NOT_LOGGED_IN -> {
                AuthActivityScreens.LOGIN_SCREEN
            }
            else -> {
                AuthActivityScreens.REGISTRATION_SCREEN
            }
        }
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
