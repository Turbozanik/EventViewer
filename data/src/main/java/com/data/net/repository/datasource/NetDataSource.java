package com.data.net.repository.datasource;

import com.data.net.retrofit.RetrofitApiCreator;
import com.data.net.retrofit.RetrofitService;
import com.data.net.sharedprefs.PrefsDataSource;

public class NetDataSource {

    private final RetrofitService mRetrofitService;

    public NetDataSource(PrefsDataSource sharedPreferences,
                         RetrofitApiCreator retrofitApiCreator) {
        mRetrofitService = retrofitApiCreator.create(sharedPreferences);
    }

//    public Flowable<BaseResponse<String>> getPrivacyPolicyUrl() {
//        return mRetrofitClientService.getPrivacyPolicyUrl();
//    }

}

