package com.view.ui.modules.content.organization.organiыationdetails.configurator

import com.view.base.configurator.BaseConfigurator
import com.view.ui.modules.content.organization.organiыationdetails.OrganisationDetailsFragmentState


class OrganisationDetailsFragmentConfigurator : BaseConfigurator<OrganisationDetailsFragmentAction, OrganisationDetailsFragmentState, OrganisationDetailsFragmentViewCommand>() {

    override fun produceViewCommand(viewState: OrganisationDetailsFragmentState,
                                    action: OrganisationDetailsFragmentAction?): OrganisationDetailsFragmentViewCommand {
        return when (action) {

            OrganisationDetailsFragmentAction.INITIAL_ACTION_DEFAULT -> {
                OrganisationDetailsFragmentViewCommand.DEFAULT
            }

            else -> {
                OrganisationDetailsFragmentViewCommand.DEFAULT
            }
        }
    }

}