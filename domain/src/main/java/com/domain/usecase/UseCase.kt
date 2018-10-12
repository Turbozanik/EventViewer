package com.domain.usecase

import io.reactivex.Flowable


abstract class UseCase<Params : Any, Result> {

    private var mParams: Params? = null

    protected abstract fun buildFlowable(params: Params?): Flowable<Result>

    abstract val isParamsRequired: Boolean

    fun setParams(params: Params): UseCase<Params, Result> {
        mParams = params
        return this
    }

    fun execute(): Flowable<Result> {
        if (isParamsRequired && mParams == null) {
            throw IllegalArgumentException("Params are required")
        } else {
            return buildFlowable(mParams)
        }

    }

}