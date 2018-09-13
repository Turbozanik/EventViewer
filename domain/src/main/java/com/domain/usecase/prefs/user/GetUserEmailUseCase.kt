package com.domain.usecase.prefs.user

import com.domain.repository.PrefsRepository
import com.domain.usecase.UseCase
import io.reactivex.Flowable


class GetUserEmailUseCase(sharedPrefsRepository: PrefsRepository) : UseCase<Any, String>() {

    private val mPrefsRepository: PrefsRepository = sharedPrefsRepository

    override fun buildFlowable(params: Any): Flowable<String> {
        return when (mPrefsRepository.getUserEmail()) {
            null -> Flowable.just("")
            else -> Flowable.just(mPrefsRepository.getUserEmail())
        }
    }

    override val isParamsRequired: Boolean
        get() = false
}