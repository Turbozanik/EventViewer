package com.view.ui.modules.content

import android.support.v4.app.Fragment
import com.view.base.fragmentfactory.BaseFragmentFactory
import com.view.ui.godlikeroot.EVENT_DETAILS_SCREEN
import com.view.ui.godlikeroot.EVENT_LIST_SCREEN
import com.view.ui.modules.auth.login.LoginFragment
import com.view.ui.modules.auth.login.configurator.LoginFragmentAction
import com.view.ui.modules.content.eventdetails.EventDetailsFragment
import com.view.ui.modules.content.eventlist.EventListFragment


class ContentFragmentFactory : BaseFragmentFactory() {

    override fun createFragment(screenKey: String?, data: Any?): Fragment {
        val fragment: Fragment
        when (screenKey) {
            EVENT_LIST_SCREEN -> {
                fragment = EventListFragment.createNewInstance()
            }
            EVENT_DETAILS_SCREEN -> {
                fragment = EventDetailsFragment.createNewInstance()
            }
            else -> {
                fragment = EventListFragment.createNewInstance()
                LoginFragment.addInitialAction(fragment, LoginFragmentAction.DEFAULT)
            }
        }
        return fragment
    }


}