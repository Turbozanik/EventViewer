package com.view.ui.modules.content.eventlist.configurator

enum class EventListFragmentViewCommand(command: Int) {
    DEFAULT(command = 0),
    LOAD_MORE_EVENTS(1),
    RELOAD_EVENTS(2);

    private val mCommand: Int = command

    companion object {
        private val map = EventListFragmentViewCommand.values()
                .associateBy(
                        EventListFragmentViewCommand::mCommand)

        fun getActionValue(
                eventListFragmentViewCommand: EventListFragmentViewCommand): Int = eventListFragmentViewCommand.mCommand

        fun getAction(command: Int) = map[command]
    }
}