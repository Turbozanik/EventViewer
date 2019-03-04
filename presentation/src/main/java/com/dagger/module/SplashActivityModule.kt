package com.dagger.module

import com.dagger.scoupe.SplashActivityScope
import com.data.repository.prefs.repository.SharedPrefsRepositoryImpl
import com.domain.usecase.prefs.user.GetUserEmailUseCase
import dagger.Module
import dagger.Provides


@Module
class SplashActivityModule {

    @Provides
    @SplashActivityScope
    fun provideGetUserEmailUseCase(
            prefsRepositoryImpl: SharedPrefsRepositoryImpl): GetUserEmailUseCase {
        return GetUserEmailUseCase(prefsRepositoryImpl)
    }

}