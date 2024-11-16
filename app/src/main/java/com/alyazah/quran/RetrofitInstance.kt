package com.alyazah.quran

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL="https://api.alquran.cloud/v1/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
    val retrofitService:SimpleService by lazy{
        getInstance().create(SimpleService::class.java)
    }
}
