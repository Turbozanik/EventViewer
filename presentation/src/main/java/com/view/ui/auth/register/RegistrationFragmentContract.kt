package com.view.ui.auth.register

import com.view.base.presenter.BaseFragmentPresenter
import com.view.base.presenter.BasePresenterContract
import com.view.base.view.BaseView
import com.view.ui.auth.register.configurator.RegistrationFragmentAction
import com.view.ui.auth.register.configurator.RegistrationFragmentConfigurator


interface RegistrationFragmentContract : BasePresenterContract {
    interface RegistrationFragmentView : BaseView {

        fun register()

    }

    abstract class RegistrationFragmentPresenter : BaseFragmentPresenter<RegistrationFragmentConfigurator, RegistrationFragmentAction, RegistrationFragmentView>()
}