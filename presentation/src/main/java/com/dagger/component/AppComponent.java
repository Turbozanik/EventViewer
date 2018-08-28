package com.dagger.component;

import com.dagger.module.ActivityModule;
import com.dagger.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    ActivitySubComponent add(ActivityModule activityModule);

}
