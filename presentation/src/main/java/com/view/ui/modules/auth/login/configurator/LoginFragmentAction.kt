package com.view.ui.modules.auth.login.configurator

import com.view.base.BaseAction


enum class LoginFragmentAction(action: Int, isInitialAction: Boolean) : BaseAction {
    DEFAULT(action = 0, isInitialAction = true),
    LOGIN_WITH_SAVED_CREDENTIALS(action = 1, isInitialAction = true),
    LOGIN_CLICK(action = 2, isInitialAction = false),
    NOT_REGISTERED_CLICK(action = 3, isInitialAction = false);

    override val mActionValue: Int = action
    override val mIsInitialAction: Boolean = isInitialAction

    companion object {
        private val map = LoginFragmentAction.values()
                .associateBy(LoginFragmentAction::mActionValue)

        fun getAction(command: Int) = map[command]

    }

}