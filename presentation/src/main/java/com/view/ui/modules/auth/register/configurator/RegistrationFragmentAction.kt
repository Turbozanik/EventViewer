package com.view.ui.modules.auth.register.configurator

import com.view.base.BaseAction


enum class RegistrationFragmentAction(action: Int, isInitialAction: Boolean) : BaseAction {
    INITIAL_ACTION_DEFAULT(action = 0, isInitialAction = true),
    REGISTER(action = 1, isInitialAction = false);

    override val mActionValue: Int = action
    override val mIsInitialAction: Boolean = isInitialAction

    companion object {
        private val map = RegistrationFragmentAction.values()
                .associateBy(RegistrationFragmentAction::mActionValue)

        fun getAction(command: Int) = map[command]
    }

}