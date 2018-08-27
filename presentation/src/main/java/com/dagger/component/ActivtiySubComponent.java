package com.dagger.component;

import com.dagger.module.ActivityModule;
import com.dagger.scoupe.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})//, NetModule.class})
public class ActivtiySubComponent {
}
