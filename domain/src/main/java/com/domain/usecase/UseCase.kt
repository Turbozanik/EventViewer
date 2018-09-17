package com.domain.usecase

import io.reactivex.Flowable


abstract class UseCase<Params : Any, Result> {

	private lateinit var mParams: Params

	protected abstract fun buildFlowable(params: Params): Flowable<Result>

	abstract val isParamsRequired: Boolean

	fun setParams(params: Params) {
		mParams = params
	}

	fun execute(): Flowable<Result> {
		if (isParamsRequired && !::mParams.isInitialized) {
			throw IllegalArgumentException("Params are required")
		} else {
			return buildFlowable(mParams)
		}

	}

}