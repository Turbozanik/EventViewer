package com.dagger.module

import com.dagger.scoupe.UserProfileActivityScope
import com.data.repository.prefs.repository.SharedPrefsRepositoryImpl
import com.domain.usecase.prefs.user.SaveUserToSharedPrefsUseCase
import dagger.Module
import dagger.Provides

@Module
class UserProfileActivityModle {

    @Provides
    @UserProfileActivityScope
    fun provideSaveUserUseCase(
            prefsRepositoryImpl: SharedPrefsRepositoryImpl): SaveUserToSharedPrefsUseCase {
        return SaveUserToSharedPrefsUseCase(prefsRepositoryImpl)
    }

}