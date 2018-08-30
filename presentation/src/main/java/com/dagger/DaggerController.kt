package com.dagger

import com.EventViewerApp
import com.dagger.component.AppComponent
import com.dagger.component.DaggerAppComponent
import com.dagger.module.AppModule


class DaggerController(eventViewerApp: EventViewerApp) {

    val appComponent: AppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(eventViewerApp))
            .build()

}