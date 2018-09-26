package com.domain.interactors

import io.reactivex.Flowable


abstract class Interactor<ParamsType : Flowable<Any>, ResultType> {

    private lateinit var mParams: List<ParamsType>

    abstract fun buildFlowable(params: List<ParamsType>): Flowable<ResultType>

    abstract val isParamsRequired: Boolean

    protected fun setParams(params: List<ParamsType>) {
        mParams = params
    }

    fun execute(): Flowable<ResultType> {
        if (isParamsRequired && !::mParams.isInitialized) {
            throw IllegalArgumentException("Params are required")
        } else {
            return buildFlowable(mParams)
        }
    }
}