package com.dagger.module

import android.content.Context
import com.dagger.scoupe.ActivityScope
import com.data.net.repository.datasource.NetDataSource
import com.data.net.retrofit.RetrofitApiCreator
import com.data.net.sharedprefs.PrefsDataSource
import dagger.Module
import dagger.Provides

@Module
class NetModule {

    @Provides
    @ActivityScope
    internal fun providePrefsDataSource(context: Context): PrefsDataSource = PrefsDataSource(context)

    @Provides
    @ActivityScope
    internal fun provideRetrofitApiCreator(): RetrofitApiCreator = RetrofitApiCreator()

    @Provides
    @ActivityScope
    internal fun provideNetDataSource(prefsDataSource: PrefsDataSource, retrofitApiCreator: RetrofitApiCreator): NetDataSource = NetDataSource(prefsDataSource, retrofitApiCreator)

}