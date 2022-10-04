package com.example.albertsonschallenge.model.remote

import com.example.albertsonschallenge.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class SearchAPI {
    val api: SearchService by lazy{
        initRetrofit()
    }

    private fun initRetrofit(): SearchService {
        return Retrofit.Builder().client(getOKHTTPClient()).baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create()).build()
            .create(SearchService::class.java)
    }

    private fun getOKHTTPClient(): OkHttpClient {
        val okhttpLogging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) okhttpLogging.level = HttpLoggingInterceptor.Level.BASIC
        else okhttpLogging.level = HttpLoggingInterceptor.Level.NONE
        return OkHttpClient.Builder().addInterceptor(okhttpLogging).build()
    }

}