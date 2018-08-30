package com.data.net.retrofit;

import io.reactivex.Flowable;
import retrofit2.http.GET;

import static com.data.net.DataLayerConstants.GET_PRIVACY_POLICY_AGREEMENT_URL;

public interface RetrofitService {
    @GET(GET_PRIVACY_POLICY_AGREEMENT_URL)
    Flowable<BaseResponse<String>> getPrivacyPolicyUrl();
}
