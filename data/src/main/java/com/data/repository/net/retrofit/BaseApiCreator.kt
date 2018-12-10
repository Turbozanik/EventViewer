package com.data.repository.net.retrofit

import com.data.BuildConfig
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier

abstract class BaseApiCreator {

    private class LoggingInterceptor : Interceptor {
        private val mInterceptor = HttpLoggingInterceptor()

        init {
            if (BuildConfig.DEBUG) mInterceptor.level = HttpLoggingInterceptor.Level.BODY
            else mInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        override fun intercept(chain: Interceptor.Chain): Response {
            return mInterceptor.intercept(chain)
        }

    }

    protected fun <T> createApi(dest: Class<T>, httpClientBuilder: OkHttpClient.Builder): T {
        //.baseUrl(BuildConfig.BASE_URL + "/" + SyncStateContract.Constants.API_SUFFIX + BuildConfig.API_VERSION_SUFFIX + "/")
        httpClientBuilder.addInterceptor(LoggingInterceptor())
        val restAdapter: Retrofit = Retrofit.Builder()
                .baseUrl("http://onliner.by")
                .client(httpClientBuilder.build())
                .addConverterFactory(getGsonConverterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return restAdapter.create(dest)
    }

    private fun getGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .excludeFieldsWithoutExposeAnnotation()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
        return gsonBuilder.create()
    }

    private fun getGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create(
            getGson())

}
