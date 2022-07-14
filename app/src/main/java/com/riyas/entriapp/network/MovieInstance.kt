package com.riyas.entriapp.network

import com.google.gson.GsonBuilder
import com.riyas.entriapp.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MovieInstance {
    companion object{
        val interceptor= HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val client= OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(25, TimeUnit.SECONDS)
        }.build()
        fun getRetrofitInstance(): Retrofit {
            return  Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                //logging Interceptor
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }


}

/*
class MovieInstance {
    companion object{
        val BASE_URL="https://api.themoviedb.org/3/discover/"
        val interceptor= HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val client= OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(25, TimeUnit.SECONDS)
        }.build()
        fun getRetrofitInstance(): Retrofit {
            return  Retrofit.Builder()
                .baseUrl(BASE_URL)
                //logging Interceptor
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }
}
* */