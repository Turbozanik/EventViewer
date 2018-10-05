package com.dagger.module

import com.dagger.scoupe.EventListFragmentScope
import com.data.net.repository.RetrofitNetRepositoryImpl
import com.domain.usecase.net.eventlist.EventListUseCase
import dagger.Module
import dagger.Provides

@Module
class EventListFragmentModule {

    @Provides
    @EventListFragmentScope
    fun provideEventListUseCase(
            retrofitNetRepositoryImpl: RetrofitNetRepositoryImpl): EventListUseCase {
        return EventListUseCase(retrofitNetRepositoryImpl)
    }

}