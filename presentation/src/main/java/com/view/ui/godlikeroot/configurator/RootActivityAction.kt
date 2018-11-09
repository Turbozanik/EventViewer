package com.view.ui.godlikeroot.configurator

import com.view.base.BaseAction


enum class RootActivityAction(action: Int, isInitialAction: Boolean) : BaseAction {
    DEFAULT(action = 0, isInitialAction = true),
    CHECK_CREDENTIALS_IN_SHARED_PREFS(1, isInitialAction = true);

    override val mActionValue: Int = action
    override val mIsInitialAction: Boolean = isInitialAction

    companion object {
        private val map = RootActivityAction.values()
                .associateBy(RootActivityAction::mActionValue)

        fun getAction(command: Int) = map[command]

    }

}