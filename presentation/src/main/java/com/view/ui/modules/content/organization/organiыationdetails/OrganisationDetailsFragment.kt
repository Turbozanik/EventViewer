package com.view.ui.modules.content.organization.organiыationdetails

import android.os.Bundle
import android.support.v4.app.Fragment
import com.FRAGMENT_DATA_KEY
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.view.R
import com.view.ui.godlikeroot.RootGodlikeActivity
import com.view.ui.modules.content.organization.organiыationdetails.configurator.OrganisationDetailsFragmentAction

class OrganisationDetailsFragment : OrganisationDetailsFragmentContract.OrganizationDetailsFragment() {


    companion object {
        fun createNewInstance(): OrganisationDetailsFragment {
            return OrganisationDetailsFragment()
        }

        fun addInitialAction(fragment: Fragment, initialAction: OrganisationDetailsFragmentAction) {
            val args = Bundle()
            args.putSerializable(FRAGMENT_DATA_KEY, initialAction)
            fragment.arguments = args
        }
    }

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var mPresenter: OrganisationDetailsFragmentPresenter
    val presenter: OrganisationDetailsFragmentPresenter get() = mPresenter

    override val layoutId: Int
        get() = R.layout.fragment_organization_details

    override fun initView() {

    }

    override fun updateToolbar() {
        (activity as RootGodlikeActivity).prepareOrganizationFragmentToolbar()
    }

    override fun handleInitialAction() {
        when (initialAction as OrganisationDetailsFragmentAction?) {

            else -> {
            }
        }
    }

    override fun addCurrentSubComponent() {
        daggerController.addOrganizationDetailsFragmentSubComponent()
    }

    override fun removeCurrentSubComponent() {
        daggerController.removeOrganizationDetailsFragmentSubComponent()
    }

    override fun sendActionAndData(action: OrganisationDetailsFragmentAction?,
                                   data: OrganisationDetailsFragmentContract.OrganizationDetailsFragmentDto?) {
        mPresenter.consumeActionAndData(action, data)
    }

}
