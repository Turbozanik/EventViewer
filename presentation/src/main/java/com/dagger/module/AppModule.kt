package com.dagger.module

import android.content.Context
import dagger.Provides
import javax.inject.Singleton

class AppModule(context: Context) {
    private val mContext = context

    @Provides
    @Singleton
    internal fun provideContext(): Context = mContext

}
