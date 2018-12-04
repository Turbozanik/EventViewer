package com.view.base.configurator

import com.view.base.BaseAction
import com.view.base.fragment.BaseState
import timber.log.Timber

abstract class BaseConfigurator<ActionType : BaseAction, StateType : BaseState<ActionType>, ViewCommandType> {

    abstract fun produceViewCommand(viewState: StateType, action: ActionType?): ViewCommandType

    fun saveAction(action: ActionType, viewState: StateType) {
        viewState.actionList.add(action)
        if (action.mIsInitialAction) {
            viewState.mInitialAction = action
        }
        Timber.d(viewState.actionList.toString())
    }

}
