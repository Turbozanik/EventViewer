package com.view.ui.godlikeroot.configurator


enum class RootActivityViewCommand(command: Int) {
    DEFAULT(command = 0),
    OPEN_AUTH_SCREEN(1),
    OPEN_CONFERENCE_SCREEN(2),
    OPEN_EVENT_LIST_SCREEN(3),
    OPEN_EVENT_DETAILS_SCREEN(4),
    GO_BACK(5);

    private val mCommand: Int = command

    companion object {
        private val map = RootActivityViewCommand.values()
                .associateBy(RootActivityViewCommand::mCommand)

        fun getActionValue(
                rootActivityViewCommand: RootActivityViewCommand): Int = rootActivityViewCommand.mCommand

        fun getAction(command: Int) = map[command]
    }
}