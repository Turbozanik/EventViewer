package com.dagger.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule(context: Context) {
    private val mContext = context

    @Provides
    @Singleton
    fun provideContext(): Context = mContext

}
