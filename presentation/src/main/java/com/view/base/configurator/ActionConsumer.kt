package com.view.base.configurator

interface ActionConsumer<ConsumedActionType, ConsumedDataType> {
    fun consumeActionAndData(action: ConsumedActionType?, data: ConsumedDataType?)
}
