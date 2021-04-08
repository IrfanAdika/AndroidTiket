package com.irfan.core.dependencies

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.irfan.core.BuildConfig
import com.irfan.core.networking.adapter.DateTimeAdapter
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val USE_INTERCEPTOR = "useInterceptor"

val networkModule = module {

    /** [kotlinx.coroutines.Deferred] support for Retrofit **/
    single<CallAdapter.Factory> { CoroutineCallAdapterFactory() }

    /** Stetho Interceptor for Network Traffic **/
    single<Interceptor> { StethoInterceptor() }

    /** Base URL for Retrofit **/
    single(qualifier = StringQualifier(BuildConfig.BASE_URL)) { BuildConfig.BASE_URL }

    /** Use the Stetho interceptor **/
    single(qualifier = StringQualifier(USE_INTERCEPTOR)) { BuildConfig.DEBUG }

    /** OkHttp client for Retrofit **/
    single {
        OkHttpClient.Builder().apply {
            addInterceptor { chain ->
                val originalRequest = chain.request()

                val urlWithQueryParams = originalRequest.url.newBuilder()
                    .build()

                chain.proceed(
                    originalRequest.newBuilder().url(urlWithQueryParams).build()
                )

            }

//            if (get(qualifier = StringQualifier(USE_INTERCEPTOR))) addNetworkInterceptor(get())

            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                addInterceptor(logging)
            }

        }.build()
    }

    /** Moshi **/
    single {
        Moshi.Builder()
            .add(DateTimeAdapter())
            .build()
    }

    /** Moshi parsing for Retrofit **/
    single<Converter.Factory> { MoshiConverterFactory.create(get()) }

    /** Retrofit **/
    single {
        Retrofit.Builder().apply {
            baseUrl(get<String>(qualifier = StringQualifier(BuildConfig.BASE_URL)))
            client(get())
            addCallAdapterFactory(get())
            addConverterFactory(get())

        }.build()
    }
}