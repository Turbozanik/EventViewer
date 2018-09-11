package com.dagger.module

import com.dagger.scoupe.AuthActivityScope
import com.data.prefs.repository.PrefsRepositoryImpl
import com.domain.usecase.prefs.user.GetUserEmailUseCase
import com.domain.usecase.prefs.user.GetUserPasswordUseCase
import dagger.Module
import dagger.Provides

@Module
class AuthActivityModule {

    @Provides
    @AuthActivityScope
    fun provideGetUserPasswordUseCase(
            prefsRepositoryImpl: PrefsRepositoryImpl): GetUserPasswordUseCase {
        return GetUserPasswordUseCase(prefsRepositoryImpl)
    }

    @Provides
    @AuthActivityScope
    fun provideGetUserEmailUseCase(prefsRepositoryImpl: PrefsRepositoryImpl): GetUserEmailUseCase {
        return GetUserEmailUseCase(prefsRepositoryImpl)
    }

}