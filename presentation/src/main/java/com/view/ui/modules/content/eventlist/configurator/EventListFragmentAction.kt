package com.view.ui.modules.content.eventlist.configurator


enum class EventListFragmentAction(action: Int, isInitialAction: Boolean) {
	INITIAL_ACTION_DEFAULT(action = 0, isInitialAction = true);

	internal val mAction: Int = action
	internal val mIsInitialAction: Boolean = isInitialAction

	companion object {
		private val map = EventListFragmentAction.values()
                .associateBy(
                        EventListFragmentAction::mAction)

		fun getAction(command: Int) = map[command]
	}

}