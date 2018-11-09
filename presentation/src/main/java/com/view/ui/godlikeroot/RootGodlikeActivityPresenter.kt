package com.view.ui.godlikeroot

import com.arellomobile.mvp.InjectViewState
import com.view.ui.godlikeroot.configurator.RootActivityAction
import com.view.ui.godlikeroot.configurator.RootActivityConfigurator

@InjectViewState
class RootGodlikeActivityPresenter : RootGodlikeActivityContract.RootActivityPresenter() {

    override fun consumeActionAndData(action: RootActivityAction?,
                                      data: RootGodlikeActivityContract.RootActivityDto?) {
        if (action != null) {
            when (action) {
                RootActivityAction.DEFAULT -> {
                }
            }
        }
    }

    override fun intiConfigurator(): RootActivityConfigurator {
        return RootActivityConfigurator()
    }
}