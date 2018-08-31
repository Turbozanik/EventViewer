package com.domain.utils


class PreconditionUtils {
    companion object {
        fun <T> checkNotNull(reference: T, errorMessage: Any): T {
            if (reference == null) {
                throw NullPointerException(errorMessage.toString())
            }
            return reference
        }
    }
}