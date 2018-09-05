package com.data.net.repository.datasource

import com.data.net.retrofit.RetrofitApiCreator

open class NetDataSource(prefsDataSource: PrefsDataSource, retrofitApiCreator: RetrofitApiCreator) {
    private val mRetrofitService = retrofitApiCreator.create(prefsDataSource)

    //    public Flowable<BaseResponse<String>> getPrivacyPolicyUrl() {
//        return mRetrofitClientService.getPrivacyPolicyUrl();
//    }

}
