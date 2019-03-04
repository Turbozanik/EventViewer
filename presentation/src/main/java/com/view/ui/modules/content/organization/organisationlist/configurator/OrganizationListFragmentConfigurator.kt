package com.view.ui.modules.content.organization.organisationlist.configurator

import com.view.base.configurator.BaseConfigurator
import com.view.ui.modules.content.organization.organisationlist.OrganisationListFragmentState

class OrganizationListFragmentConfigurator : BaseConfigurator<OrganisationListFragmentAction, OrganisationListFragmentState, OrganisationListFragmentViewCommand>() {
    override fun produceViewCommand(viewState: OrganisationListFragmentState,
                                    action: OrganisationListFragmentAction?): OrganisationListFragmentViewCommand {
        return when (action) {
            OrganisationListFragmentAction.INITIAL_ACTION_DEFAULT -> {
                OrganisationListFragmentViewCommand.DEFAULT
            }
            null -> {
                OrganisationListFragmentViewCommand.DEFAULT
            }
        }
    }
}