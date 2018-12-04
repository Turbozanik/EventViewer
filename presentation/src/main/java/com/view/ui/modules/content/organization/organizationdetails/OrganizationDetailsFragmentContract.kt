package com.view.ui.modules.content.organization.organizationdetails

import com.view.base.BasePresenter
import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.ui.modules.content.organization.organizationdetails.configurator.OrganizationDetailsFragmentAction
import com.view.ui.modules.content.organization.organizationdetails.configurator.OrganizationDetailsFragmentConfigurator

class OrganizationDetailsFragmentContract {

    data class OrganizationDetailsFragmentDto(var dummy: Boolean)

    abstract class OrganizationDetailsPresenter : BasePresenter<OrganizationDetailsFragmentConfigurator, OrganizationDetailsFragmentAction, OrganizationDetailsFragmentDto, OrganizationDetailsFragmentView>() {
        init {
            this.intiConfigurator()
            this.injectPresenter()
        }
    }

    abstract class OrganizationDetailsFragment : PresenterFragment(), OrganizationDetailsFragmentView, ActionProducer<OrganizationDetailsFragmentAction, OrganizationDetailsFragmentDto>

}
