package com.data.net.retrofit;

import com.cryospav2.data.entity.response.BaseResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

import static com.cryospav2.data.Constants.GET_PRIVACY_POLICY_AGREEMENT_URL;

public interface RetrofitClientService {
    @GET(GET_PRIVACY_POLICY_AGREEMENT_URL)
    Flowable<BaseResponse<String>> getPrivacyPolicyUrl();
}
