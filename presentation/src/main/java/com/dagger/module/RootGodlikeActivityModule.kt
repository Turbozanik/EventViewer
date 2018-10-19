package com.dagger.module

import com.dagger.scoupe.RootGodlikeActivityScope
import com.data.prefs.repository.SharedPrefsRepositoryImpl
import com.domain.usecase.prefs.user.GetUserEmailUseCase
import com.domain.usecase.prefs.user.GetUserPasswordUseCase
import com.domain.usecase.prefs.user.SaveUserToSharedPrefsUseCase
import dagger.Module
import dagger.Provides

@Module
class RootGodlikeActivityModule {

    @Provides
    @RootGodlikeActivityScope
    fun provideSaveUserUseCase(
            prefsRepositoryImpl: SharedPrefsRepositoryImpl): SaveUserToSharedPrefsUseCase {
        return SaveUserToSharedPrefsUseCase(prefsRepositoryImpl)
    }

    @Provides
    @RootGodlikeActivityScope
    fun provideGetUserPasswordUseCase(
            prefsRepositoryImpl: SharedPrefsRepositoryImpl): GetUserPasswordUseCase {
        return GetUserPasswordUseCase(prefsRepositoryImpl)
    }

    @Provides
    @RootGodlikeActivityScope
    fun provideGetUserEmailUseCase(
            prefsRepositoryImpl: SharedPrefsRepositoryImpl): GetUserEmailUseCase {
        return GetUserEmailUseCase(prefsRepositoryImpl)
    }

}