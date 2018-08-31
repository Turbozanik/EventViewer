package com.domain.usecase

import com.domain.utils.PreconditionUtils
import io.reactivex.Flowable
import java.util.*


abstract class UseCase<Result, Params> {
    private var mOptional: Optional<Params>? = null

    abstract fun buildFlowable(optional: Optional<Params>?): Flowable<Result>

    abstract fun isParamsRequired(): Boolean

    protected fun setParams(params: Params) {
        if (params != null) {
            mOptional = Optional.of(params)
        }
    }

    fun execute(): Flowable<Result> {
        if (isParamsRequired()) {
            PreconditionUtils.checkNotNull(mOptional?.get(), "Param is null!")
        }
        return PreconditionUtils.checkNotNull(buildFlowable(mOptional), "Flowable is null!")
    }

}