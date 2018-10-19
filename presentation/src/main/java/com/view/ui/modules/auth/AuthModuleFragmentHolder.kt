package com.view.ui.modules.auth

import android.app.Activity
import android.support.v4.app.Fragment
import com.InitialAction
import com.view.base.module.BaseModule
import com.view.ui.modules.auth.login.LoginFragment
import com.view.ui.modules.auth.login.configurator.LoginFragmentAction
import com.view.ui.modules.auth.register.RegistrationFragment
import com.view.ui.modules.auth.register.configurator.RegistrationFragmentAction


open class AuthModuleFragmentHolder(context: Activity, fragmentContainerId: Int) : BaseModule(
        context,
        fragmentContainerId) {

    override fun createFragment(screenKey: String?, data: Any?,
                                initialInitialAction: InitialAction): Fragment {
        val fragment: Fragment
        when (screenKey) {
            LOGIN_SCREEN -> {
                fragment = LoginFragment.createNewInstance()
                if (initialInitialAction == com.InitialAction.OPEN_AUTH_WITH_NO_SAVED_CREDENTIALS) {
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