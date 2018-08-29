package com.data.net.repository

import com.domain.repository.NetRepository
import io.reactivex.Flowable

class RetrofitNetRepositoryImpl : NetRepository {
    override fun getPrivacyPolicy(): Flowable<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
