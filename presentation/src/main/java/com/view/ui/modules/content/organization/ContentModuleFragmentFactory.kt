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
import com.view.ui.modules.content.organization.organisationlist.OrganisationListFragment
import com.view.ui.modules.content.organization.organisationlist.configurator.OrganisationListFragmentAction
import com.view.ui.modules.content.organization.organiыationdetails.OrganisationDetailsFragment
import com.view.ui.modules.content.organization.organiыationdetails.configurator.OrganisationDetailsFragmentAction


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
            ORGANIZATION_DETAILS_SCREEN -> {
                fragment = OrganisationDetailsFragment.createNewInstance()
                OrganisationDetailsFragment.addInitialAction(fragment,
                                                             OrganisationDetailsFragmentAction.INITIAL_ACTION_DEFAULT)
            }
            ORGANIZATION_LIST_SCREEN -> {
                fragment = OrganisationListFragment.createNewInstance()
                OrganisationListFragment.addInitialAction(fragment,
                                                          OrganisationListFragmentAction.INITIAL_ACTION_DEFAULT)
            }
            else -> {
                fragment = LoginFragment.createNewInstance()
                LoginFragment.addInitialAction(fragment, LoginFragmentAction.DEFAULT)
            }
        }
        return fragment
    }

}