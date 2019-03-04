package com.dagger.component

import com.dagger.module.OrganizationFragmentDetailsModule
import com.dagger.scoupe.OrganizationFragmentDetailsScope
import com.view.ui.modules.content.organization.organiыationdetails.OrganisationDetailsFragmentPresenter
import dagger.Subcomponent

@OrganizationFragmentDetailsScope
@Subcomponent(modules = [OrganizationFragmentDetailsModule::class])
interface OrganizationFragmentDetailsSubComponent {

    fun inject(organizationDetailsPresenter: OrganisationDetailsFragmentPresenter)

}