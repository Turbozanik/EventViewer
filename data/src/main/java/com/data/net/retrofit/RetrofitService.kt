package com.data.net.retrofit

import com.data.GET_PRIVACY_POLICY_AGREEMENT_URL
import com.data.net.pojo.User
import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.GET

interface RetrofitService {

    @GET(GET_PRIVACY_POLICY_AGREEMENT_URL)
    fun register(@Body map: Map<String, String?>): Flowable<BaseResponse<User?>>

    @GET(GET_PRIVACY_POLICY_AGREEMENT_URL)
    fun login(@Body map: Map<String, String?>): Flowable<BaseResponse<User?>>
}