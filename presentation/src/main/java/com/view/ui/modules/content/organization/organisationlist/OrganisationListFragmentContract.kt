package com.view.ui.modules.content.organization.organisationlist

import com.view.base.BasePresenter
import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.base.fragment.presenter.BasePresenterContract
import com.view.ui.modules.content.organization.organisationlist.configurator.OrganisationListFragmentAction
import com.view.ui.modules.content.organization.organisationlist.configurator.OrganizationListFragmentConfigurator

interface OrganisationListFragmentContract : BasePresenterContract {

    data class OrganisationListFragmentDto(var dummy: Boolean)

    abstract class OrganizationListPresenter : BasePresenter<OrganizationListFragmentConfigurator, OrganisationListFragmentAction, OrganisationListFragmentDto, OrganisationListFragmentView>() {
        init {
            this.intiConfigurator()
        }
    }

    abstract class OrganizationListFragment : PresenterFragment(), OrganisationListFragmentView, ActionProducer<OrganisationListFragmentAction, OrganisationListFragmentDto>

}
