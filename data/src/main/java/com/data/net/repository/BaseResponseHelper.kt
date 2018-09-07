package com.data.net.repository

import com.data.net.retrofit.BaseResponse
import io.reactivex.Flowable


class BaseResponseHelper {
    fun <T> validateFlowable(
            responseFlowable: Flowable<BaseResponse<T?>>): Flowable<BaseResponse<T?>> {
        return responseFlowable.flatMap<BaseResponse<T?>> { tBaseResponse ->
            Flowable.just<BaseResponse<T?>>(tBaseResponse)
        }
    }

    fun <T> unwrapBaseResponse(
            responseFlowable: Flowable<BaseResponse<T?>>): Flowable<T?> {
        return responseFlowable.flatMap { tBaseResponse ->
            Flowable.just(tBaseResponse.getResult())
        }
    }
}