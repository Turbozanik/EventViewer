package com.view.ui.modules.content.organization.organiыationdetails

import com.view.base.BasePresenter
import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.ui.modules.content.organization.organiыationdetails.configurator.OrganisationDetailsFragmentAction
import com.view.ui.modules.content.organization.organiыationdetails.configurator.OrganisationDetailsFragmentConfigurator

class OrganisationDetailsFragmentContract {

    data class OrganizationDetailsFragmentDto(var dummy: Boolean)

    abstract class OrganizationDetailsPresenter : BasePresenter<OrganisationDetailsFragmentConfigurator, OrganisationDetailsFragmentAction, OrganizationDetailsFragmentDto, OrganisationDetailsFragmentView>() {
        init {
            this.intiConfigurator()
        }
    }

    abstract class OrganizationDetailsFragment : PresenterFragment(), OrganisationDetailsFragmentView, ActionProducer<OrganisationDetailsFragmentAction, OrganizationDetailsFragmentDto>

}
