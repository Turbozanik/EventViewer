package com.view.ui.modules.auth.login

import com.view.base.presenter.BasePresenterContract


interface LoginFragmentContract : BasePresenterContract {

    data class UserCredentials(val email: String, val password: String)

    data class LoginFragmentDto(var userCredentials: UserCredentials,
                                val shouldSaveCredentials: Boolean)

}