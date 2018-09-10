package com.dagger.module

import com.dagger.scoupe.LoginFragmentScope
import com.data.net.repository.RetrofitNetRepositoryImpl
import com.domain.usecase.login.LoginUseCase
import dagger.Module
import dagger.Provides


@Module
class LoginFragmentModule {

    @Provides
    @LoginFragmentScope
    fun provideLoginUseCase(
            retrofitNetRepositoryImpl: RetrofitNetRepositoryImpl): LoginUseCase {
        return LoginUseCase(retrofitNetRepositoryImpl)
    }

}