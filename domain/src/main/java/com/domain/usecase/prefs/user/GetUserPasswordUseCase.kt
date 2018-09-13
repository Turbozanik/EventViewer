package com.domain.usecase.prefs.user

import com.domain.repository.SharedPrefsRepository
import com.domain.usecase.UseCase
import io.reactivex.Flowable


class GetUserPasswordUseCase(
        sharedSharedPrefsRepository: SharedPrefsRepository) : UseCase<Any, String>() {

    private val mSharedPrefsRepository: SharedPrefsRepository = sharedSharedPrefsRepository

    override fun buildFlowable(params: Any): Flowable<String> {
        return when (mSharedPrefsRepository.getUserPassword()) {
            null -> Flowable.just("")
            else -> Flowable.just(mSharedPrefsRepository.getUserPassword())
        }
    }

    override val isParamsRequired: Boolean
        get() = false
}