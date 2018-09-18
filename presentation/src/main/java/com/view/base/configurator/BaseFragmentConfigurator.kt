package com.view.base.configurator

abstract class BaseFragmentConfigurator<StateType, ActionType, ViewCommandType> {

	abstract fun produceViewCommand(viewState: StateType, action: ActionType): ViewCommandType

}
