package com.view.ui.modules.content.organization.organiыationdetails.configurator


enum class OrganisationDetailsFragmentViewCommand(command: Int) {
    DEFAULT(command = 0);

    private val mCommand: Int = command

    companion object {
        private val map = OrganisationDetailsFragmentViewCommand.values()
                .associateBy(
                        OrganisationDetailsFragmentViewCommand::mCommand)

        fun getActionValue(
                organizationDetailsFragmentViewCommand: OrganisationDetailsFragmentViewCommand): Int = organizationDetailsFragmentViewCommand.mCommand

        fun getAction(command: Int) = map[command]
    }
}