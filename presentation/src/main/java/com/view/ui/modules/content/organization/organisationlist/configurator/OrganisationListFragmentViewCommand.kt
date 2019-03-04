package com.view.ui.modules.content.organization.organisationlist.configurator

enum class OrganisationListFragmentViewCommand(command: Int) {

    DEFAULT(command = 0);

    private val mCommand: Int = command

    companion object {
        private val map = OrganisationListFragmentViewCommand.values()
                .associateBy(
                        OrganisationListFragmentViewCommand::mCommand)

        fun getActionValue(
                organizationsListFragmentViewCommand: OrganisationListFragmentViewCommand): Int = organizationsListFragmentViewCommand.mCommand

        fun getAction(command: Int) = map[command]
    }
}