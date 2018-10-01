package com.view.ui.main.eventlist.configurator

enum class EventListFragmentViewCommand(command: Int) {
	DEFAULT(command = 0);

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