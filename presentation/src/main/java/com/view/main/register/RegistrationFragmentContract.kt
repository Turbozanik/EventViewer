package com.view.main.register

import com.view.base.configurator.BaseFragmentConfigurator
import com.view.base.presenter.BaseFragmentPresenter
import com.view.base.presenter.BasePresenterContract
import com.view.base.view.BaseView
import com.view.main.register.configurator.RegistrationFragmentAction
import com.view.main.register.configurator.RegistrationFragmentViewCommand


interface RegistrationFragmentContract : BasePresenterContract {
    interface RegistrationFragmentView : BaseView {

        fun dummyFun()

    }

    abstract class RegistrationFragmentPresenter : BaseFragmentPresenter<BaseFragmentConfigurator<RegistrationFragmentState, RegistrationFragmentAction, RegistrationFragmentViewCommand>, RegistrationFragmentAction, RegistrationFragmentView>()
}