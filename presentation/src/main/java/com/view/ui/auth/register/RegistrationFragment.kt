package com.view.ui.auth.register

import android.os.Bundle
import android.support.v4.app.Fragment
import com.FRAGMENT_DATA_KEY
import com.view.R
import com.view.ui.auth.register.configurator.RegistrationFragmentAction
import javax.inject.Inject


class RegistrationFragment : RegistrationFragmentContract.RegistrationFragment() {

	companion object {
		fun createNewInstance(): RegistrationFragment {
			return RegistrationFragment()
		}

		fun addInitialAction(fragment: Fragment, initialAction: RegistrationFragmentAction) {
			val args = Bundle()
			args.putSerializable(FRAGMENT_DATA_KEY, initialAction)
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

	override fun getViewData(): RegistrationFragmentContract.RegistrationFragmentDto {
		return RegistrationFragmentContract.RegistrationFragmentDto(
				RegistrationFragmentContract.RegistrationInfo("", ""), true)
	}

	override fun goToEventsFragment() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

}