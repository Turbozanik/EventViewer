package com.dagger.module

import com.dagger.scoupe.MainActivityScope
import com.data.prefs.repository.SharedPrefsRepositoryImpl
import com.domain.usecase.prefs.user.SaveUserToSharedPrefsUseCase
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @MainActivityScope
    fun provideSaveUserUseCase(
            prefsRepositoryImpl: SharedPrefsRepositoryImpl): SaveUserToSharedPrefsUseCase {
        return SaveUserToSharedPrefsUseCase(prefsRepositoryImpl)
    }

}