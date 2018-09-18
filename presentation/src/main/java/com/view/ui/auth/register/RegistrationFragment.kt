package com.view.ui.auth.register

import android.os.Bundle
import android.support.v4.app.Fragment
import com.Constants
import com.view.R
import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.ui.auth.register.configurator.RegistrationFragmentAction
import javax.inject.Inject


class RegistrationFragment : PresenterFragment<RegistrationFragmentContract.RegistrationFragmentPresenter>(), ActionProducer<RegistrationFragmentAction>, RegistrationFragmentContract.RegistrationFragmentView {

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
		daggerController.registrationFragmentSubComponent?.inject(this)
	}

	override fun addCurrentSubComponent() {
		daggerController.addRegistrationFragmentSubComponent()
	}

	override fun removeCurrentSubComponent() {
		daggerController.removeRegistrationFragmentSubComponent()
	}

	override val layoutId: Int
		get() = R.layout.fragment_ragistration

	override fun initView() {
	}

	override val presenter: RegistrationFragmentPresenter
		get() {
			return mPresenter
		}

	override fun sendAction(action: RegistrationFragmentAction?) {
		mPresenter.consumeAction(action)
	}

	override fun register() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

}