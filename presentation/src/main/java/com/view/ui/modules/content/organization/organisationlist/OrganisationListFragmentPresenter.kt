package com.view.ui.modules.content.organization.organisationlist

import com.EventViewerApp
import com.arellomobile.mvp.InjectViewState
import com.view.ui.modules.content.organization.organisationlist.configurator.OrganisationListFragmentAction
import com.view.ui.modules.content.organization.organisationlist.configurator.OrganisationListFragmentViewCommand
import com.view.ui.modules.content.organization.organisationlist.configurator.OrganizationListFragmentConfigurator
import com.watchers.keepers.UserKeeper
import javax.inject.Inject

@InjectViewState
class OrganisationListFragmentPresenter : OrganisationListFragmentContract.OrganizationListPresenter() {

    @Inject
    lateinit var mUserKeeper: UserKeeper

    private val mOrganizationListFragmentState: OrganisationListFragmentState = OrganisationListFragmentState()

    override fun intiConfigurator(): OrganizationListFragmentConfigurator {
        return OrganizationListFragmentConfigurator()
    }

    override fun consumeActionAndData(action: OrganisationListFragmentAction?,
                                      data: OrganisationListFragmentContract.OrganisationListFragmentDto?) {
        action?.let { actionCopy: OrganisationListFragmentAction ->
            updateViewState(actionCopy)
            when (actionConfigurator.produceViewCommand(mOrganizationListFragmentState,
                                                        actionCopy)) {
                OrganisationListFragmentViewCommand.DEFAULT -> {
                    mUserKeeper.user
                }
            }
        }
    }

    override fun updateViewState(action: OrganisationListFragmentAction) {

    }

    override fun injectPresenter() {
        EventViewerApp.getInstance().getDaggerController()
                .organizationListFragmentSubComponent?.inject(
                this)
    }

}