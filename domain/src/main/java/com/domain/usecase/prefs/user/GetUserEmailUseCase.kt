package com.domain.usecase.prefs.user

import com.domain.repository.PrefsRepository
import com.domain.usecase.UseCase
import io.reactivex.Flowable


class GetUserEmailUseCase(sharedPrefsRepository: PrefsRepository) : UseCase<String?, Void>() {

    private val mPrefsRepository: PrefsRepository = sharedPrefsRepository

    override fun buildFlowable(params: Void): Flowable<String?> {
        return Flowable.just(mPrefsRepository.getUserEmail())
    }

    override val isParamsRequired: Boolean
        get() = false
}