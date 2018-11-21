package com.view.ui.modules.profile

import android.support.v4.app.Fragment
import com.view.base.fragmentfactory.BaseFragmentFactory
import com.view.ui.modules.profile.userprofile.UserProfileFragment
import com.view.ui.modules.profile.userprofile.configurator.UserProfileFragmentAction


class ProfileModuleFragmentFactory : BaseFragmentFactory() {
    override fun createFragment(screenKey: String?, data: Any?): Fragment {
        val fragment: Fragment
        when (screenKey) {
            PROFILE_SCREEN -> {
                fragment = UserProfileFragment.createNewInstance()
                UserProfileFragment.addInitialAction(fragment, UserProfileFragmentAction.DEFAULT)
            }
            else -> {
                fragment = UserProfileFragment.createNewInstance()
                UserProfileFragment.addInitialAction(fragment, UserProfileFragmentAction.DEFAULT)
            }
        }
        return fragment
    }
}