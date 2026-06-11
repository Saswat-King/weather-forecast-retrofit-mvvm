package com.kingstudio.weatherforecast.api

import com.kingstudio.weatherforecast.model.response.GeoCodingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApi {

    @GET("search")
    suspend fun getLocation(

        @Query("name") city: String,
        @Query("count") count: Int = 1
    ): GeoCodingResponse
}