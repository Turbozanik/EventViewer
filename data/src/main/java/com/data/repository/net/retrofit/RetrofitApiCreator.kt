package com.data.repository.net.retrofit

import com.data.repository.prefs.datasource.PrefsDataSource
import okhttp3.OkHttpClient


open class RetrofitApiCreator : BaseApiCreator() {
    fun create(prefsDataSource: PrefsDataSource): RetrofitService {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor { chain ->
            val request = chain.request().newBuilder().build()
            chain.proceed(request)
        }
        return createApi(RetrofitService::class.java, okHttpClientBuilder)
    }
}