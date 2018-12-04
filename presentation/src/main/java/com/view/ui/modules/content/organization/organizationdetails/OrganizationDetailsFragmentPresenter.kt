package com.view.ui.modules.content.organization.organizationdetails

import com.EventViewerApp
import com.view.ui.modules.content.organization.organizationdetails.configurator.OrganizationDetailsFragmentAction
import com.view.ui.modules.content.organization.organizationdetails.configurator.OrganizationDetailsFragmentConfigurator
import com.view.ui.modules.content.organization.organizationdetails.configurator.OrganizationDetailsFragmentViewCommand


class OrganizationDetailsFragmentPresenter : OrganizationDetailsFragmentContract.OrganizationDetailsPresenter() {

    private val mOrganizationDetailsFragmentState: OrganizationDetailsFragmentState = OrganizationDetailsFragmentState()

    override fun injectPresenter() {
        EventViewerApp.getInstance().getDaggerController()
                .organizationDetailsFragmentSubComponent?.inject(this)
    }

    override fun consumeActionAndData(action: OrganizationDetailsFragmentAction?,
                                      data: OrganizationDetailsFragmentContract.OrganizationDetailsFragmentDto?) {
        action?.let {
            when (actionConfigurator.produceViewCommand(mOrganizationDetailsFragmentState, it)) {

                OrganizationDetailsFragmentViewCommand.DEFAULT -> {

                }

            }
        }
    }

    override fun intiConfigurator(): OrganizationDetailsFragmentConfigurator {
        return OrganizationDetailsFragmentConfigurator()
    }

}