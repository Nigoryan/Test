package com.example.speciallist.network

import com.example.speciallist.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object UserRepository {
    private lateinit var service: UserService

    fun getService(): UserService{
        if(!::service.isInitialized){
            service = Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build()
                .create(UserService::class.java)
        }
        return service
    }

    private fun getClient(): OkHttpClient{
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .callTimeout(3,TimeUnit.SECONDS)
        return client.build()
    }
}