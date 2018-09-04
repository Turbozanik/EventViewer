package com.view.base.configurator;

public interface ActionConsumer<ConsumedActionType> {

    void consumeAction(ConsumedActionType action);

}
