package com.dagger.component

import com.dagger.module.MainActivityModule
import com.dagger.scoupe.MainActivityScope
import dagger.Subcomponent

@MainActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivitySubComponent