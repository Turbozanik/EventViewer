package com.view.ui.godlikeroot.configurator

import com.view.base.configurator.BaseConfigurator
import com.view.ui.godlikeroot.RootGodlikeActivityState


class RootActivityConfigurator : BaseConfigurator<RootActivityAction, RootGodlikeActivityState, RootActivityViewCommand>() {
    override fun produceViewCommand(viewState: RootGodlikeActivityState,
                                    action: RootActivityAction): RootActivityViewCommand {
        return when (action) {
            RootActivityAction.DEFAULT -> {
                RootActivityViewCommand.DEFAULT
            }
        }
    }
}