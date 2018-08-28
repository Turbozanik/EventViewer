package com.data.net.retrofit;

import com.data.net.sharedprefs.PrefsDataSource;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ClientApiCreator extends BaseApiCreator {

    public RetrofitService create(final PrefsDataSource preferenceManager) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(chain -> {
            Request request = chain.request()
                    .newBuilder()
//                    .header(HEADER_TOKEN, TOKEN_PREFIX + preferenceManager.getCustomerToken())
//                    .header(HEADER_DEVICE_ID, String.valueOf(preferenceManager.getDeviceId()))
//                    .header(HEADER_BUILD_VERSION, String.valueOf(BuildConfig.VERSION_CODE))
                    .build();
            return chain.proceed(request);
        });
        return createApi(RetrofitService.class, httpClientBuilder);
    }
}
