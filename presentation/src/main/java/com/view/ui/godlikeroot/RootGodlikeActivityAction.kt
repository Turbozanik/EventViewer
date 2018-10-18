package com.view.ui.godlikeroot

enum class RootGodlikeActivityAction(action: Int) {
    DEFAULT(action = 0);

    private val mAction: Int = action

    companion object {
        private val map = RootGodlikeActivityAction.values().associateBy(
                RootGodlikeActivityAction::mAction)

        fun getActionValue(
                rootGodlikeActivityAction: RootGodlikeActivityAction): Int = rootGodlikeActivityAction.mAction

        fun getAction(command: Int) = map[command]
    }

}