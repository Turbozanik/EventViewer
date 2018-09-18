package com.utils

import java.util.concurrent.Executors

class BgExecutors private constructor() {

	init {
		throw IllegalStateException("this is utility class")
	}

	companion object {
		val Executor = Executors.newScheduledThreadPool(
				Runtime.getRuntime().availableProcessors())!!
	}

}
