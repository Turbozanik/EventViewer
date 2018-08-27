package com.dagger;

import com.EventViewerApp;
import com.dagger.component.AppComponent;
import com.dagger.component.DaggerAppComponent;
import com.dagger.module.AppModule;

public class DaggerController {

    private final AppComponent mAppComponent;

    public DaggerController(EventViewerApp eventViewerApp) {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(eventViewerApp))
                .build();
    }

}
