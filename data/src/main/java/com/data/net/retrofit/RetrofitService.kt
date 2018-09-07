package com.data.net.retrofit

import com.data.net.GET_PRIVACY_POLICY_AGREEMENT_URL
import com.data.net.pojo.User
import io.reactivex.Flowable
import retrofit2.http.GET

interface RetrofitService {

    @GET(GET_PRIVACY_POLICY_AGREEMENT_URL)
    fun register(): Flowable<BaseResponse<User?>>
}
