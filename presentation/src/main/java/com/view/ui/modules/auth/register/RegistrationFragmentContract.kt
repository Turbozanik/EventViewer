package com.view.ui.modules.auth.register

import com.view.base.presenter.BasePresenterContract


interface RegistrationFragmentContract : BasePresenterContract {

    data class RegistrationInfo(var mane: String, var nickamne: String, var email: String,
                                var birthday: String, var password: String,
                                var repeatPassword: String)

    data class RegistrationFragmentDto(var registrationInfo: RegistrationInfo,
                                       val shouldSaveCredentials: Boolean)

}