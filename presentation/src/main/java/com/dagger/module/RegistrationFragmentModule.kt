package com.dagger.module

import com.dagger.scoupe.RegistrationFragmentScope
import com.data.net.repository.RetrofitNetRepositoryImpl
import com.domain.usecase.net.registration.RegisterUserCase
import dagger.Module
import dagger.Provides

@Module
class RegistrationFragmentModule {

	@Provides
	@RegistrationFragmentScope
	fun provideRegistrationUseCase(
			retrofitNetRepositoryImpl: RetrofitNetRepositoryImpl): RegisterUserCase {
		return RegisterUserCase(retrofitNetRepositoryImpl)
	}

}