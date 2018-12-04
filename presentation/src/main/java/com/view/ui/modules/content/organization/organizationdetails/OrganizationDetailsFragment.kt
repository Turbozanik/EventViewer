package com.view.ui.modules.content.organization.organizationdetails

import android.os.Bundle
import android.support.v4.app.Fragment
import com.FRAGMENT_DATA_KEY
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.view.R
import com.view.ui.modules.content.organization.organizationdetails.configurator.OrganizationDetailsFragmentAction
import kotlinx.android.synthetic.main.activity_root_with_toolbar.*

class OrganizationDetailsFragment : OrganizationDetailsFragmentContract.OrganizationDetailsFragment() {


    companion object {
        fun createNewInstance(): OrganizationDetailsFragment {
            return OrganizationDetailsFragment()
        }

        fun addInitialAction(fragment: Fragment, initialAction: OrganizationDetailsFragmentAction) {
            val args = Bundle()
            args.putSerializable(FRAGMENT_DATA_KEY, initialAction)
            fragment.arguments = args
        }
    }

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var mPresenter: OrganizationDetailsFragmentPresenter
    val presenter: OrganizationDetailsFragmentPresenter get() = mPresenter

    override val layoutId: Int
        get() = R.layout.fragment_organization_details

    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateToolbar() {
        mToolbar.title = getString(R.string.orgagizations)
    }

    override fun handleInitialAction() {
        when (initialAction as OrganizationDetailsFragmentAction?) {

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

    override fun sendActionAndData(action: OrganizationDetailsFragmentAction?,
                                   data: OrganizationDetailsFragmentContract.OrganizationDetailsFragmentDto?) {
        mPresenter.consumeActionAndData(action, data)
    }

}
