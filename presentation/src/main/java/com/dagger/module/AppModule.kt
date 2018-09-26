package com.dagger.module

import android.content.Context
import com.data.prefs.datasource.PrefsDataSource
import com.data.prefs.repository.SharedPrefsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(context: Context) {
    private val mContext = context

    @Provides
    @Singleton
    fun provideContext(): Context = mContext


    @Provides
    @Singleton
    fun providePrefsDataSource(context: Context): PrefsDataSource = PrefsDataSource(context)

    @Provides
    @Singleton
    fun providePrefsRepository(
            prefsDataSource: PrefsDataSource): SharedPrefsRepositoryImpl = SharedPrefsRepositoryImpl(
            prefsDataSource)

}
