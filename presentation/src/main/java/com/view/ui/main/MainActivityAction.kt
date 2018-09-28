package com.view.ui.main

enum class MainActivityAction(action: Int) {
    DEFAULT(action = 0);

    private val mAction: Int = action

    companion object {
        private val map = MainActivityAction.values().associateBy(
                MainActivityAction::mAction)

        fun getActionValue(mainActivityAction: MainActivityAction): Int = mainActivityAction.mAction

        fun getAction(command: Int) = map[command]
    }

}