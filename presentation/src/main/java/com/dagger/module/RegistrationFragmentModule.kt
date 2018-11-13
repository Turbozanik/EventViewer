package com.dagger.module

import com.dagger.scoupe.RegistrationFragmentScope
import com.domain.repository.NetRepository
import com.domain.usecase.net.registration.RegisterUserCase
import dagger.Module
import dagger.Provides

@Module
class RegistrationFragmentModule {

    @Provides
    @RegistrationFragmentScope
    fun provideRegistrationUseCase(netRepository: NetRepository): RegisterUserCase {
        return RegisterUserCase(netRepository)
    }

}