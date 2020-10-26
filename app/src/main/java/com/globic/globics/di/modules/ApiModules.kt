package com.globic.globics.di.modules

import android.app.Application
import androidx.viewbinding.BuildConfig
import com.globic.globics.network.api.ApiService
import com.globic.globics.network.interceptor.HeaderInterceptor
import com.globic.globics.network.interceptor.NetworkInterceptor
import com.globic.globics.network.monitor.INetworkMonitor
import com.globic.globics.network.monitor.NetworkMonitor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModules {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    internal fun provideCache(application: Application): Cache {
        val cacheSize = (10 * 1024 * 1024).toLong() // 10 MB
        val httpCacheDirectory = File(application.cacheDir, "http-cache")
        return Cache(httpCacheDirectory, cacheSize)
    }

    @Provides
    @Singleton
    fun provideNetworkInterceptor(application: Application, networkMonitor: INetworkMonitor
    ): NetworkInterceptor {
        return NetworkInterceptor(application.applicationContext, networkMonitor)
    }

    @Provides
    @Singleton
    fun provideNetworkMonitor(application: Application): INetworkMonitor {
        return NetworkMonitor(application.applicationContext)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(headersInterceptor: HeaderInterceptor, networkInterceptor: NetworkInterceptor,
                            cache: Cache?): OkHttpClient {
        val builder = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        builder.addInterceptor(logging)
        builder.addInterceptor(headersInterceptor)
        builder.addInterceptor(networkInterceptor)
        builder.cache(cache)
        builder.connectTimeout(60, TimeUnit.SECONDS)
        builder.readTimeout(60, TimeUnit.SECONDS)
        builder.writeTimeout(60, TimeUnit.SECONDS)
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, gson: Gson, okHttpClient: OkHttpClient): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}