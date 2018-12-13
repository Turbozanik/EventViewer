package com.dagger.component

import com.dagger.module.OrganizationFragmentDetailsModule
import com.dagger.scoupe.EventListFragmentScope
import com.view.ui.modules.content.organization.organiыationdetails.OrganisationDetailsFragmentPresenter
import dagger.Subcomponent

@EventListFragmentScope
@Subcomponent(modules = [OrganizationFragmentDetailsModule::class])
interface OrganizationFragmentDetailsSubComponent {

    fun inject(organizationDetailsPresenter: OrganisationDetailsFragmentPresenter)

}