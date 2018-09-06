package com.domain.usecase

import io.reactivex.Flowable


abstract class UseCase<Result, Params : Any> {

    private lateinit var mParams: Params

    abstract fun buildFlowable(params: Params): Flowable<Result>

    abstract fun isParamsRequired(): Boolean

    protected fun setParams(params: Params) {
        mParams = params
    }

    fun execute(): Flowable<Result> {
        if (isParamsRequired() && !::mParams.isInitialized) {
            throw IllegalArgumentException("Params are required")
        } else {
            return buildFlowable(mParams)
        }

    }

}