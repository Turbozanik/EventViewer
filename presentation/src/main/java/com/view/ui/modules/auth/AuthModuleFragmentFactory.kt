package com.view.ui.modules.auth

import android.support.v4.app.Fragment
import com.view.base.fragmentfactory.BaseFragmentFactory
import com.view.ui.modules.auth.login.LoginFragment
import com.view.ui.modules.auth.login.configurator.LoginFragmentAction
import com.view.ui.modules.auth.register.RegistrationFragment
import com.view.ui.modules.auth.register.configurator.RegistrationFragmentAction


open class AuthModuleFragmentFactory : BaseFragmentFactory() {
    override fun createFragment(screenKey: String?, data: Any?): Fragment {
        val fragment: Fragment
        when (screenKey) {
            LOGIN_SCREEN -> {
                fragment = LoginFragment.createNewInstance()
                LoginFragment.addInitialAction(fragment, LoginFragmentAction.DEFAULT)
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