package com.dagger.component

import com.dagger.module.OrganizationListFragmentModule
import com.dagger.scoupe.OrganizationListFragmentScope
import com.view.ui.modules.content.organization.organisationlist.OrganisationListFragmentPresenter
import dagger.Subcomponent


@OrganizationListFragmentScope
@Subcomponent(modules = [OrganizationListFragmentModule::class])
interface OrganizationListFragmentSubComponent {

    fun inject(organisationListFragmentPresenter: OrganisationListFragmentPresenter)

}