package com.dagger.component

import com.dagger.module.MainActivityModule
import dagger.Module
import dagger.Subcomponent

@Module
@Subcomponent(modules = [MainActivityModule::class])
class MainActivitySubComponent