package com.view.ui.main.eventdetails.configurator


enum class EventDetailsFragmentViewCommand(command: Int) {
    DEFAULT(command = 0);

    private val mCommand: Int = command

    companion object {
        private val map = EventDetailsFragmentViewCommand.values()
                .associateBy(EventDetailsFragmentViewCommand::mCommand)

        fun getActionValue(
                eventDetailsFragmentViewCommand: EventDetailsFragmentViewCommand): Int = eventDetailsFragmentViewCommand.mCommand

        fun getAction(command: Int) = map[command]
    }
}