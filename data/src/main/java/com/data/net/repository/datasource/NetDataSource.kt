package com.data.net.repository.datasource

import com.data.net.pojo.User
import com.data.net.retrofit.BaseResponse
import com.data.net.retrofit.RetrofitApiCreator
import io.reactivex.Flowable

open class NetDataSource(prefsDataSource: PrefsDataSource, retrofitApiCreator: RetrofitApiCreator) {
    private val mRetrofitService = retrofitApiCreator.create(prefsDataSource)

    fun register(map: Map<String, String>): Flowable<BaseResponse<User?>> {
        return mRetrofitService.register(map)
    }

}
