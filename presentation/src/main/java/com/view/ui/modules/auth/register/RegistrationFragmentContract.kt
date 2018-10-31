package com.view.ui.modules.auth.register

import com.view.base.configurator.ActionProducer
import com.view.base.fragment.PresenterFragment
import com.view.base.presenter.BaseFragmentPresenter
import com.view.base.presenter.BasePresenterContract
import com.view.base.view.BaseView
import com.view.ui.modules.auth.register.configurator.RegistrationFragmentAction
import com.view.ui.modules.auth.register.configurator.RegistrationFragmentConfigurator


interface RegistrationFragmentContract : BasePresenterContract {

    data class RegistrationInfo(var mane: String, var nickamne: String, var email: String,
                                var birthday: String, var password: String,
                                var repeatPassword: String)

    data class RegistrationFragmentDto(var registrationInfo: RegistrationInfo,
                                       val shouldSaveCredentials: Boolean)

    interface RegistrationFragmentView : BaseView {

        fun goToEventsFragment()

    }

    abstract class RegistrationFragmentPresenter : BaseFragmentPresenter<RegistrationFragmentConfigurator, RegistrationFragmentAction, RegistrationFragmentDto, RegistrationFragmentView>()

    abstract class RegistrationFragment : PresenterFragment(), ActionProducer<RegistrationFragmentAction, RegistrationFragmentDto>, RegistrationFragmentView

}