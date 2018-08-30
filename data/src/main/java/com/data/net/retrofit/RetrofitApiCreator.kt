package com.data.net.retrofit

import com.data.net.sharedprefs.PrefsDataSource
import okhttp3.OkHttpClient


class RetrofitApiCreator : BaseApiCreator() {
    fun create(prefsDataSource: PrefsDataSource): RetrofitService {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor { chain ->
            val request = chain.request().newBuilder().build()
            chain.proceed(request)
        }
        return createApi(RetrofitService::class.java, okHttpClientBuilder)
    }
}