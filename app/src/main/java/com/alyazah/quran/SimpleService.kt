package com.alyazah.quran

import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleService {
    @GET("quran/{edition}")
    suspend fun getQuran(@Path("edition") edition: String): Quran
}