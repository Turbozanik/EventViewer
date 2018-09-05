package com.view.ui.register

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.base.presenter.BaseFragmentPresenter
import com.view.base.presenter.BasePresenterContract
import com.view.base.view.BaseView
import com.view.ui.register.configurator.RegistrationFragmentAction
import com.view.ui.register.configurator.RegistrationFragmentViewCommand


interface RegistrationFragmentContract : BasePresenterContract {
    interface RegistrationFragmentView : BaseView {

        fun register()

    }

    abstract class RegistrationFragmentPresenter : BaseFragmentPresenter<BaseFragmentConfigurator<RegistrationFragmentState, RegistrationFragmentAction, RegistrationFragmentViewCommand>, RegistrationFragmentAction, RegistrationFragmentView>()
}