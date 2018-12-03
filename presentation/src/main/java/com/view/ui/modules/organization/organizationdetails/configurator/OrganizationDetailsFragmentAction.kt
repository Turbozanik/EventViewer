package com.view.ui.modules.organization.organizationdetails.configurator

import com.view.base.BaseAction
import com.view.ui.modules.auth.register.configurator.RegistrationFragmentAction


enum class OrganizationDetailsFragmentAction(action: Int, isInitialAction: Boolean) : BaseAction {

    INITIAL_ACTION_DEFAULT(action = 0, isInitialAction = true),
    ORGANIZATION_DETAILS(action = 1, isInitialAction = false);

    override val mActionValue: Int = action
    override val mIsInitialAction: Boolean = isInitialAction

    companion object {
        private val map = RegistrationFragmentAction.values()
                .associateBy(RegistrationFragmentAction::mActionValue)

        fun getAction(command: Int) = map[command]
    }
}