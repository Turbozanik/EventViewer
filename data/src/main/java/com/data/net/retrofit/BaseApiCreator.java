package com.data.net.retrofit;

import com.data.BuildConfig;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Modifier;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

// TODO: 10.07.2018 check all commented lines
public abstract class BaseApiCreator {

    private final class LoggingInterceptor implements Interceptor {
        private HttpLoggingInterceptor mInterceptor;

        LoggingInterceptor() {
            mInterceptor = new HttpLoggingInterceptor();
            mInterceptor.setLevel(BuildConfig.DEBUG
                                  ? HttpLoggingInterceptor.Level.BODY
                                  : HttpLoggingInterceptor.Level.NONE);
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            return mInterceptor.intercept(chain);
        }
    }

    <T> T createApi(final Class<T> dest, OkHttpClient.Builder httpClientBuilder) {
        httpClientBuilder.addInterceptor(new LoggingInterceptor());
        Retrofit restAdapter = new Retrofit.Builder()
                //.baseUrl(BuildConfig.BASE_URL + "/" + SyncStateContract.Constants.API_SUFFIX + BuildConfig.API_VERSION_SUFFIX + "/")
                .baseUrl("http://onliner.by")
                .client(httpClientBuilder.build())
                .addConverterFactory(getGsonConverterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return restAdapter.create(dest);
    }

    private Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                //.registerTypeAdapter(Medical.class, new MedicalDeserializer())
                .excludeFieldsWithoutExposeAnnotation()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC);
        return gsonBuilder.create();
    }

    private GsonConverterFactory getGsonConverterFactory() {
        return GsonConverterFactory.create(getGson());
    }

}
