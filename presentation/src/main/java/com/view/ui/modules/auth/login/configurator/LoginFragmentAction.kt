package com.view.ui.modules.auth.login.configurator

import com.view.base.BaseAction


enum class LoginFragmentAction(action: Int, isInitialState: Boolean) : BaseAction {
    DEFAULT(action = 0, isInitialState = true),
    LOGIN_WITH_SAVED_CREDENTIALS(action = 1, isInitialState = true),
    LOGIN_CLICK(action = 2, isInitialState = false),
    NOT_REGISTERED_CLICK(action = 3, isInitialState = false);

    override val mActionValue: Int = action
    override val mIsInitialAction: Boolean = isInitialState

    companion object {
        private val map = LoginFragmentAction.values()
                .associateBy(LoginFragmentAction::mActionValue)

        fun getAction(command: Int) = map[command]

    }

}