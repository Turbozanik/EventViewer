package com.view.ui.modules.content

import android.support.v4.app.Fragment
import com.view.base.fragmentfactory.BaseFragmentFactory
import com.view.ui.modules.auth.login.LoginFragment
import com.view.ui.modules.auth.login.configurator.LoginFragmentAction
import com.view.ui.modules.content.eventlist.EventListFragment
import com.view.ui.modules.organization.ORGANIZATION_LIST


class ContentFragmentFactory : BaseFragmentFactory() {
    override fun createFragment(screenKey: String?, data: Any?): Fragment {
        val fragment: Fragment
        when (screenKey) {
            ORGANIZATION_LIST -> {
                fragment = EventListFragment.createNewInstance()
            }
            else -> {
                fragment = EventListFragment.createNewInstance()
                LoginFragment.addInitialAction(fragment, LoginFragmentAction.DEFAULT)
            }
        }
        return fragment
    }


}