package com.view.ui.modules.content.organization.organizationdetails.configurator


enum class OrganizationDetailsFragmentViewCommand(command: Int) {
    DEFAULT(command = 0);

    private val mCommand: Int = command

    companion object {
        private val map = OrganizationDetailsFragmentViewCommand.values()
                .associateBy(
                        OrganizationDetailsFragmentViewCommand::mCommand)

        fun getActionValue(
                organizationDetailsFragmentViewCommand: OrganizationDetailsFragmentViewCommand): Int = organizationDetailsFragmentViewCommand.mCommand

        fun getAction(command: Int) = map[command]
    }
}