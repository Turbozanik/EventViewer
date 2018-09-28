package com.view.base.configurator

import com.view.base.fragment.BaseState

abstract class BaseFragmentConfigurator<ActionType, StateType : BaseState<ActionType>, ViewCommandType> {

    abstract fun produceViewCommand(viewState: StateType, action: ActionType): ViewCommandType

    abstract fun saveAction(action: ActionType, viewState: StateType)

}
