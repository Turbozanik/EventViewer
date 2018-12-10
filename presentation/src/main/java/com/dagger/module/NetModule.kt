package com.dagger.module

import com.dagger.scoupe.ActivityScope
import com.data.repository.net.datasource.NetDataSource
import com.data.repository.net.repository.RetrofitNetRepositoryImpl
import com.data.repository.net.retrofit.RetrofitApiCreator
import com.data.repository.prefs.datasource.PrefsDataSource
import com.domain.repository.NetRepository
import dagger.Module
import dagger.Provides

@Module
class NetModule {

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