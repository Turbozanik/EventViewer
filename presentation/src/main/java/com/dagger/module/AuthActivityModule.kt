package com.dagger.module

import com.dagger.scoupe.AuthActivityScope
import com.data.repository.prefs.repository.SharedPrefsRepositoryImpl
import com.domain.usecase.prefs.user.GetUserEmailUseCase
import com.domain.usecase.prefs.user.GetUserPasswordUseCase
import com.domain.usecase.prefs.user.SaveUserToSharedPrefsUseCase
import dagger.Module
import dagger.Provides

@Module
class AuthActivityModule {

    @Provides
    @AuthActivityScope
    fun provideGetUserPasswordUseCase(
            prefsRepositoryImpl: SharedPrefsRepositoryImpl): GetUserPasswordUseCase {
        return GetUserPasswordUseCase(prefsRepositoryImpl)
    }

    @Provides
    @AuthActivityScope
    fun provideGetUserEmailUseCase(
            prefsRepositoryImpl: SharedPrefsRepositoryImpl): GetUserEmailUseCase {
        return GetUserEmailUseCase(prefsRepositoryImpl)
    }

    @Provides
    @AuthActivityScope
    fun provideSaveUserUseCase(
            prefsRepositoryImpl: SharedPrefsRepositoryImpl): SaveUserToSharedPrefsUseCase {
        return SaveUserToSharedPrefsUseCase(prefsRepositoryImpl)
    }

}