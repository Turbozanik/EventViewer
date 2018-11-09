package com.view.ui.godlikeroot

import com.view.base.BasePresenter
import com.view.base.activity.BaseActivity
import com.view.base.fragment.presenter.BasePresenterContract
import com.view.ui.godlikeroot.configurator.RootActivityAction
import com.view.ui.godlikeroot.configurator.RootActivityConfigurator


interface RootGodlikeActivityContract : BasePresenterContract {

    data class RootActivityDto(val dummy: Boolean)

    abstract class RootActivityPresenter : BasePresenter<RootActivityConfigurator, RootActivityAction, RootActivityDto, RootGodlikeActivityView>() {
        init {
            this.intiConfigurator()
        }
    }

    abstract class RootActivity : BaseActivity(), RootGodlikeActivityView

}