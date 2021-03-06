package com.view.ui.godlikeroot.configurator

import com.view.base.BaseAction


enum class RootActivityAction(action: Int, isInitialAction: Boolean) : BaseAction {
    DEFAULT(action = 0, isInitialAction = true),
    EVENT_LIST_ITEM_CLICK(1, isInitialAction = false),
    CONFERENCE_ITEM_CLICK(2, isInitialAction = false),
    BACK_CLICK(3, isInitialAction = false),
    USER_PROFILE_CLICK(4, isInitialAction = false),
    COMPANY_DETAILS_CLICK(5, false),
    COMPANY_LIST_CLICK(6, false);

    override val mActionValue: Int = action
    override val mIsInitialAction: Boolean = isInitialAction

    companion object {
        private val map = RootActivityAction.values()
                .associateBy(RootActivityAction::mActionValue)

        fun getAction(command: Int) = map[command]

    }

}