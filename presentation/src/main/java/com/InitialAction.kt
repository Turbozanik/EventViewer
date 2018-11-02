package com

import com.view.base.BaseAction
import com.view.base.BaseInitialAction


enum class InitialAction(action: Int, isInitialAction: Boolean) : BaseAction, BaseInitialAction {
    DEFAULT(0, isInitialAction = true),
    OPEN_MAIN(action = 1, isInitialAction = true),
    OPEN_AUTH(action = 2, isInitialAction = true),
    OPEN_AUTH_WITH_NO_SAVED_CREDENTIALS(action = 3, isInitialAction = true),
    OPEN_AUTH_WITH_SAVED_CREDENTIALS(action = 4, isInitialAction = true),
    OPEN_MAIN_WITH_EVENT_LIST_FRAGMENT(action = 5, isInitialAction = true);

    override val mActionValue: Int = action
    override val mIsInitialAction: Boolean = isInitialAction

    companion object {
        private val map = InitialAction.values().associateBy(InitialAction::mActionValue)

        fun getActionValue(initialAction: InitialAction): Int = initialAction.mActionValue

        fun getAction(command: Int) = map[command]

    }

}