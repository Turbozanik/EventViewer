package com.view.ui.modules.content.organization.organiыationdetails

import com.EventViewerApp
import com.view.ui.modules.content.organization.organiыationdetails.configurator.OrganisationDetailsFragmentAction
import com.view.ui.modules.content.organization.organiыationdetails.configurator.OrganisationDetailsFragmentConfigurator
import com.view.ui.modules.content.organization.organiыationdetails.configurator.OrganisationDetailsFragmentViewCommand


class OrganisationDetailsFragmentPresenter : OrganisationDetailsFragmentContract.OrganizationDetailsPresenter() {

    private val mOrganizationDetailsFragmentState: OrganisationDetailsFragmentState = OrganisationDetailsFragmentState()

    override fun injectPresenter() {
        EventViewerApp.getInstance().getDaggerController()
                .organizationDetailsFragmentSubComponent?.inject(this)
    }

    override fun consumeActionAndData(action: OrganisationDetailsFragmentAction?,
                                      data: OrganisationDetailsFragmentContract.OrganizationDetailsFragmentDto?) {
        action?.let {
            updateViewState(action)
            when (actionConfigurator.produceViewCommand(mOrganizationDetailsFragmentState, it)) {

                OrganisationDetailsFragmentViewCommand.DEFAULT -> {

                }

            }
        }
    }

    override fun updateViewState(action: OrganisationDetailsFragmentAction) {

    }

    override fun intiConfigurator(): OrganisationDetailsFragmentConfigurator {
        return OrganisationDetailsFragmentConfigurator()
    }

}