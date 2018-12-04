package com.view.ui.modules.content.organization.organizationdetails.configurator

import com.view.base.configurator.BaseConfigurator
import com.view.ui.modules.content.organization.organizationdetails.OrganizationDetailsFragmentState


class OrganizationDetailsFragmentConfigurator : BaseConfigurator<OrganizationDetailsFragmentAction, OrganizationDetailsFragmentState, OrganizationDetailsFragmentViewCommand>() {

    override fun produceViewCommand(viewState: OrganizationDetailsFragmentState,
                                    action: OrganizationDetailsFragmentAction?): OrganizationDetailsFragmentViewCommand {
        action?.let {
            return when (it) {

                OrganizationDetailsFragmentAction.INITIAL_ACTION_DEFAULT -> {
                    return OrganizationDetailsFragmentViewCommand.DEFAULT
                }

            }
        }
    }

}