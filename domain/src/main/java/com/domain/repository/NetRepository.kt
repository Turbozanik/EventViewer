package com.domain.repository

import io.reactivex.Flowable

interface NetRepository {
    fun getPrivacyPolicy(): Flowable<String>
}
