package com.view.ui.modules.content.organization.organisationlist.configurator

import com.view.base.BaseAction

enum class OrganisationListFragmentAction(action: Int, isInitialAction: Boolean) : BaseAction {
    INITIAL_ACTION_DEFAULT(action = 0, isInitialAction = true);

    override val mActionValue: Int = action
    override val mIsInitialAction: Boolean = isInitialAction

    companion object {
        private val map = OrganisationListFragmentAction.values()
                .associateBy(OrganisationListFragmentAction::mActionValue)

        fun getAction(command: Int) = map[command]
    }

}