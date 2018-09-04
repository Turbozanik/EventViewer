package com.dagger.module

import android.content.Context
import com.dagger.scoupe.ActivityScope
import com.data.net.repository.RetrofitNetRepositoryImpl
import com.data.net.repository.datasource.NetDataSource
import com.data.net.retrofit.RetrofitApiCreator
import com.data.net.sharedprefs.PrefsDataSource
import com.domain.repository.NetRepository
import dagger.Module
import dagger.Provides

@Module
open class NetModule {

    @Provides
    @ActivityScope
    fun providePrefsDataSource(context: Context): PrefsDataSource = PrefsDataSource(context)

    @Provides
    @ActivityScope
    fun provideRetrofitApiCreator(): RetrofitApiCreator = RetrofitApiCreator()

    @Provides
    @ActivityScope
    fun provideNetDataSource(prefsDataSource: PrefsDataSource,
                             retrofitApiCreator: RetrofitApiCreator): NetDataSource = NetDataSource(
            prefsDataSource, retrofitApiCreator)

    @Provides
    @ActivityScope
    fun provideNetRepository(
            netDataSource: NetDataSource): NetRepository = RetrofitNetRepositoryImpl(netDataSource)

}