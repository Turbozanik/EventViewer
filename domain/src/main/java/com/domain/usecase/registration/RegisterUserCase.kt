package com.domain.usecase.registration

import com.domain.models.UserDto
import com.domain.repository.NetRepository
import com.domain.usecase.UseCase
import io.reactivex.Flowable


class RegisterUserCase(
        retrofitNetRepository: NetRepository) : UseCase<UserDto, Map<String, String>>() {

    private val mRetrofitNetRepository: NetRepository = retrofitNetRepository

    override fun buildFlowable(params: Map<String, String>): Flowable<UserDto?> {
        return mRetrofitNetRepository.register(params)
    }

    override val isParamsRequired: Boolean
        get() {
            return true
        }

}