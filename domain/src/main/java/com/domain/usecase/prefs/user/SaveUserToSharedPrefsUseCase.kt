package com.domain.usecase.prefs.user

import com.domain.repository.SharedPrefsRepository
import com.domain.usecase.UseCase
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable


class SaveUserToSharedPrefsUseCase(
        sharedSharedPrefsRepo: SharedPrefsRepository) : UseCase<Pair<String, String>, Any>() {

    private val mSharedPrefsRepository: SharedPrefsRepository = sharedSharedPrefsRepo

    override fun buildFlowable(params: Pair<String, String>?): Flowable<Any> {
        return Flowable.create<Any>({
                                        mSharedPrefsRepository.saveUserEmail(params?.first)
                                        mSharedPrefsRepository.saveUserPassword(params?.second)
        }, BackpressureStrategy.DROP)
    }

    override val isParamsRequired: Boolean
        get() = true

}