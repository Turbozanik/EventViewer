package com.data.net.datasource

import com.data.net.pojo.User
import com.data.net.retrofit.BaseResponse
import com.data.net.retrofit.RetrofitApiCreator
import com.data.prefs.datasource.PrefsDataSource
import io.reactivex.Flowable

open class NetDataSource(prefsDataSource: PrefsDataSource, retrofitApiCreator: RetrofitApiCreator) {
    private val mRetrofitService = retrofitApiCreator.create(prefsDataSource)

    fun register(map: Map<String, String>): Flowable<BaseResponse<User?>> {
        return mRetrofitService.register(map)
    }

    fun login(body: Map<String, String>): Flowable<BaseResponse<User?>> {
        return mRetrofitService.login(body)
    }

}
