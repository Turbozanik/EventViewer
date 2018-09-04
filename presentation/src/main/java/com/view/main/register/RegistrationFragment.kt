package com.view.main.register

import android.os.Bundle
import android.support.v4.app.Fragment
import com.Constants
import com.EventViewerApp
import com.view.base.fragment.PresenterFragment
import com.view.base.presenter.BaseFragmentPresenter
import com.view.main.register.configurator.RegistrationFragmentAction
import javax.inject.Inject


class RegistrationFragment : PresenterFragment() {

    companion object {
        fun createNewInstance(): RegistrationFragment {
            return RegistrationFragment()
        }

        fun addInitialAction(fragment: Fragment, initialAction: RegistrationFragmentAction) {
            val args = Bundle()
            args.putSerializable(Constants.FRAGMENT_DATA_KEY, initialAction)
            fragment.arguments = args
        }
    }

    @Inject
    lateinit var mPresenter: RegistrationFragmentPresenter

    override fun inject() {
        EventViewerApp.getInstance().getDaggerController().getRegistrationFragmentSubComponent()
                ?.inject(this)
    }

    override fun addCurrentSubComponent() {
        EventViewerApp.getInstance().getDaggerController().addRegistrationFragmnetSubComponent()
    }

    override fun removeCurrentSubComponent() {
        EventViewerApp.getInstance().getDaggerController().removeRegistrationFragmentSubComponent()
    }

    override val layoutId: Int
        get() = TODO(
                "not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPresenter(): BaseFragmentPresenter<*, *, *> {
        return mPresenter
    }

}