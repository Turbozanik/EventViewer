package com.view.ui.modules.content.organization.organiыationdetails.configurator

import com.view.base.configurator.BaseConfigurator
import com.view.ui.modules.content.organization.organiыationdetails.OrganisationDetailsFragmentState


class OrganisationDetailsFragmentConfigurator : BaseConfigurator<OrganisationDetailsFragmentAction, OrganisationDetailsFragmentState, OrganisationDetailsFragmentViewCommand>() {

    override fun produceViewCommand(viewState: OrganisationDetailsFragmentState,
                                    action: OrganisationDetailsFragmentAction?): OrganisationDetailsFragmentViewCommand {
        action?.let {
            return when (it) {

                OrganisationDetailsFragmentAction.INITIAL_ACTION_DEFAULT -> {
                    return OrganisationDetailsFragmentViewCommand.DEFAULT
                }

            }
        }
    }

}