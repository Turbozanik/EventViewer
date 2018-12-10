package com.data.repository.net.helpers

import com.data.repository.net.retrofit.BaseResponse
import io.reactivex.Flowable


class BaseResponseHelper {
    fun <T> validateFlowable(
            responseFlowable: Flowable<BaseResponse<T?>?>): Flowable<BaseResponse<T?>> {
        return responseFlowable.flatMap<BaseResponse<T?>> { tBaseResponse: BaseResponse<T?>? ->
            when (tBaseResponse) {
                null -> Flowable.just<BaseResponse<T?>>(BaseResponse<T?>().empty)
                else -> Flowable.just<BaseResponse<T?>>(tBaseResponse)
            }
        }
    }

    fun <T> unwrapBaseResponse(
            responseFlowable: Flowable<BaseResponse<T?>>): Flowable<T?> {
        return responseFlowable.flatMap { tBaseResponse ->
            Flowable.just(tBaseResponse.getBaseResponseResult())
        }
    }
}