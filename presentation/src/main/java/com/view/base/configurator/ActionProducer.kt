package com.view.base.configurator


interface ActionProducer<ActionType, DataType> {

    fun sendActionAndData(action: ActionType?, data: DataType?)

}
