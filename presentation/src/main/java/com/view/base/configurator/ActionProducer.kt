package com.view.base.configurator


interface ActionProducer<ActionType> {

    fun sendAction(action: ActionType?)

}
