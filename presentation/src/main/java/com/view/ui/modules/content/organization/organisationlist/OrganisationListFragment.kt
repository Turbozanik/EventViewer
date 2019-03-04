package com.view.ui.modules.content.organization.organisationlist

import android.os.Bundle
import android.support.v4.app.Fragment
import com.FRAGMENT_DATA_KEY
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.view.R
import com.view.ui.godlikeroot.RootGodlikeActivity
import com.view.ui.modules.content.organization.organisationlist.configurator.OrganisationListFragmentAction

class OrganisationListFragment : OrganisationListFragmentContract.OrganizationListFragment() {

    companion object {
        fun createNewInstance(): OrganisationListFragment {
            return OrganisationListFragment()
        }

        fun addInitialAction(fragment: Fragment, initialAction: OrganisationListFragmentAction) {
            val args = Bundle()
            args.putSerializable(FRAGMENT_DATA_KEY, initialAction)
            fragment.arguments = args
        }
    }

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var mPresenter: OrganisationListFragmentPresenter
    val presenter: OrganisationListFragmentPresenter get() = mPresenter

    override val layoutId: Int
        get() = R.layout.fragment_organization_list

    override fun initView() {

    }

    override fun updateToolbar() {
        activity?.let { (activity as RootGodlikeActivity).prepareOrganizationListFragmentToolbar() }
    }

    override fun handleInitialAction() {
        when (initialAction as OrganisationListFragmentAction?) {
            OrganisationListFragmentAction.INITIAL_ACTION_DEFAULT -> {
            }
            else -> {
            }
        }
    }

    override fun addCurrentSubComponent() {
        daggerController.addOrganizationListFragmentSubComponent()
    }

    override fun removeCurrentSubComponent() {
        daggerController.removeOrganizationListFragmentSubComponent()
    }

    override fun sendActionAndData(action: OrganisationListFragmentAction?,
                                   data: OrganisationListFragmentContract.OrganisationListFragmentDto?) {
        mPresenter.consumeActionAndData(action, data)
    }

}
