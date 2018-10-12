package com.domain.usecase.net.eventlist

import com.domain.models.UserDto
import com.domain.repository.NetRepository
import com.domain.usecase.UseCase
import io.reactivex.Flowable

class EventListUseCase(
        retrofitNetRepository: NetRepository) : UseCase<Map<String, String?>, UserDto>() {

    private val mRetrofitNetRepository: NetRepository = retrofitNetRepository

    override fun buildFlowable(params: Map<String, String?>?): Flowable<UserDto> {
        return mRetrofitNetRepository.login(params)
    }

    override val isParamsRequired: Boolean
        get() = true

}