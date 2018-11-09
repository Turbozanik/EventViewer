package com.view.ui.godlikeroot.configurator


enum class RootActivityViewCommand(command: Int) {
    DEFAULT(command = 0);

    private val mCommand: Int = command

    companion object {
        private val map = RootActivityViewCommand.values()
                .associateBy(RootActivityViewCommand::mCommand)

        fun getActionValue(
                rootActivityViewCommand: RootActivityViewCommand): Int = rootActivityViewCommand.mCommand

        fun getAction(command: Int) = map[command]
    }
}