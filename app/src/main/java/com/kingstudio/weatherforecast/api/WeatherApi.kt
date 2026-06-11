package com.kingstudio.weatherforecast.api

import com.kingstudio.weatherforecast.model.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    suspend fun getWeather(

        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current_weather") currentWeather: Boolean = true

    ): WeatherResponse


}