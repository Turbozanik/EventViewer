package com.view.main.register

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.main.register.configurator.RegistrationFragmentAction
import com.view.main.register.configurator.RegistrationFragmentViewCommand
import javax.inject.Inject


class RegistrationFragmentPresenter @Inject constructor() : RegistrationFragmentContract.RegistrationFragmentPresenter(), RegistrationFragmentContract.RegistrationFragmentView {

    override fun intiConfigurator(
            actionConfigurator: BaseFragmentConfigurator<RegistrationFragmentState, RegistrationFragmentAction, RegistrationFragmentViewCommand>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun consumeAction(action: RegistrationFragmentAction?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dummyFun() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}