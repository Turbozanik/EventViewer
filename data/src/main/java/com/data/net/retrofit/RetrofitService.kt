package com.data.net.retrofit

import com.data.net.GET_PRIVACY_POLICY_AGREEMENT_URL
import io.reactivex.Flowable
import retrofit2.http.GET

interface RetrofitService {

    @GET(GET_PRIVACY_POLICY_AGREEMENT_URL)
    fun getPrivacyPolicyAgreement(): Flowable<BaseResponse<String>>
}
