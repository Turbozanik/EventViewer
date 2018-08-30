package com.data.net.repository

import com.data.net.repository.datasource.NetDataSource
import com.domain.repository.NetRepository
import io.reactivex.Flowable

class RetrofitNetRepositoryImpl(netDataSource: NetDataSource) : NetRepository {
    override fun getPrivacyPolicy(): Flowable<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
