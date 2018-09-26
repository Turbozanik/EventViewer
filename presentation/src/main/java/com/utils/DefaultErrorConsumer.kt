package com.utils

import io.reactivex.functions.Consumer
import timber.log.Timber


class DefaultErrorConsumer : Consumer<Throwable> {
    override fun accept(throwable: Throwable) {
        Timber.e(throwable)
    }

}