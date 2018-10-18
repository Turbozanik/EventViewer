package com.view.ui.modules.auth

import android.app.Activity
import android.support.v4.app.Fragment
import com.ActivityAction
import com.view.base.module.BaseModule
import com.view.ui.modules.auth.login.LoginFragment
import com.view.ui.modules.auth.login.configurator.LoginFragmentAction
import com.view.ui.modules.auth.register.RegistrationFragment
import com.view.ui.modules.auth.register.configurator.RegistrationFragmentAction


open class AuthModuleNavigator(context: Activity, fragmentContainerId: Int) : BaseModule(
        context,
        fragmentContainerId) {

    fun createFragment(screenKey: String?, data: Any?,
                       activityInitialAction: ActivityAction): Fragment {
        val fragment: Fragment
        when (screenKey) {
            LOGIN_SCREEN -> {
                fragment = LoginFragment.createNewInstance()
                if (activityInitialAction == com.ActivityAction.OPEN_AUTH_ACTIVITY_WITH_NO_SAVED_CREDENTIALS) {
                    LoginFragment.addInitialAction(fragment,
                                                   LoginFragmentAction.DEFAULT)
                }
            }
            REGISTRATION_SCREEN -> {
                fragment = RegistrationFragment.createNewInstance()
                RegistrationFragment.addInitialAction(fragment,
                                                      RegistrationFragmentAction.INITIAL_ACTION_DEFAULT)
            }
            else -> {
                fragment = LoginFragment.createNewInstance()
                LoginFragment.addInitialAction(fragment, LoginFragmentAction.DEFAULT)
            }
        }
        return fragment
    }

}