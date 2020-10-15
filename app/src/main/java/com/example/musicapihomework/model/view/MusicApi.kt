package com.example.musicapihomework.model.view

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object MusicApi {
    fun initRetrofit(): Api {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(addOkHttpClient())
            .build()
        return retrofit.create(Api::class.java)
    }

    private fun addOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(addLoggingInterceptor())
            .build()
    }

    private fun addLoggingInterceptor(): Interceptor {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC
        return logger
    }

    //https://itunes.apple.com/search?term=rock&amp;media=music&amp;entity=song&amp;limit=50
//https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50
//https://itunes.apple.com/search?term=pop&amp;media=music&amp;entity=song&amp;limit=50
    interface Api {
        @GET("search")
        fun getThatMusic(
            @Query("term") term: String,
            @Query("limit") limit: Int = 50
        ): Call<itunesApiResults>
    }
}