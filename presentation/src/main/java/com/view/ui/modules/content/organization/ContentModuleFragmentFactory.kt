package com.view.ui.modules.content.organization

import android.support.v4.app.Fragment
import com.view.base.fragmentfactory.BaseFragmentFactory
import com.view.ui.modules.auth.login.LoginFragment
import com.view.ui.modules.auth.login.configurator.LoginFragmentAction
import com.view.ui.modules.auth.register.RegistrationFragment
import com.view.ui.modules.auth.register.configurator.RegistrationFragmentAction
import com.view.ui.modules.content.eventdetails.EventDetailsFragment
import com.view.ui.modules.content.eventdetails.configurator.EventDetailsFragmentAction
import com.view.ui.modules.content.eventlist.EventListFragment
import com.view.ui.modules.content.eventlist.configurator.EventListFragmentAction
import com.view.ui.modules.content.organization.organizationdetails.OrganizationDetailsFragment
import com.view.ui.modules.content.organization.organizationdetails.configurator.OrganizationDetailsFragmentAction


class ContentModuleFragmentFactory : BaseFragmentFactory() {

    override fun createFragment(screenKey: String?, data: Any?): Fragment {
        val fragment: Fragment
        when (screenKey) {
            EVENT_LIST_SCREEN -> {
                fragment = EventListFragment.createNewInstance()
                EventListFragment.addInitialAction(fragment,
                                                   EventListFragmentAction.INITIAL_ACTION_DEFAULT)
            }
            EVENT_DETAILS_SCREEN -> {
                fragment = EventDetailsFragment.createNewInstance()
                EventDetailsFragment.addInitialAction(fragment,
                                                      EventDetailsFragmentAction.INITIAL_ACTION_DEFAULT)
            }
            EVENT_LIST_WITH_SAVED_CREDENTIALS_SCREEN -> {
                fragment = RegistrationFragment.createNewInstance()
                RegistrationFragment.addInitialAction(fragment,
                                                      RegistrationFragmentAction.INITIAL_ACTION_DEFAULT)
            }
            EVENT_ORGANIZATION_DETAILS_SCREEN -> {
                fragment = OrganizationDetailsFragment.createNewInstance()
                OrganizationDetailsFragment.addInitialAction(fragment,
                                                             OrganizationDetailsFragmentAction.INITIAL_ACTION_DEFAULT)
            }
            EVENT_ORGANIZATION_LIST_SCREEN -> {
                //todo replace with correct fragment
                fragment = OrganizationDetailsFragment.createNewInstance()
                OrganizationDetailsFragment.addInitialAction(fragment,
                                                             OrganizationDetailsFragmentAction.INITIAL_ACTION_DEFAULT)
            }
            else -> {
                fragment = LoginFragment.createNewInstance()
                LoginFragment.addInitialAction(fragment, LoginFragmentAction.DEFAULT)
            }
        }
        return fragment
    }

}