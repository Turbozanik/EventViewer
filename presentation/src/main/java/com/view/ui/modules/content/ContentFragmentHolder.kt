package com.view.ui.modules.content

import android.app.Activity
import android.support.v4.app.Fragment
import com.InitialAction
import com.view.base.module.BaseModule
import com.view.ui.godlikeroot.EVENT_DETAILS_SCREEN
import com.view.ui.godlikeroot.EVENT_LIST_SCREEN
import com.view.ui.modules.auth.login.LoginFragment
import com.view.ui.modules.auth.login.configurator.LoginFragmentAction
import com.view.ui.modules.content.eventdetails.EventDetailsFragment
import com.view.ui.modules.content.eventlist.EventListFragment


class ContentFragmentHolder(context: Activity, fragmentContainerId: Int) : BaseModule(
        context,
        fragmentContainerId) {
    override fun createFragment(screenKey: String?, data: Any?,
                                initialInitialAction: InitialAction): Fragment {
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