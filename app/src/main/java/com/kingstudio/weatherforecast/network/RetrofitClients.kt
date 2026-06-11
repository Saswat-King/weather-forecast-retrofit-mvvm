package com.kingstudio.weatherforecast.network

import com.kingstudio.weatherforecast.api.GeocodingApi
import com.kingstudio.weatherforecast.api.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object GeocodingClient{

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://geocoding-api.open-meteo.com/v1/").
         addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: GeocodingApi by lazy {

        retrofit.create(GeocodingApi::class.java)
    }

}

object WeatherClient{


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.open-meteo.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: WeatherApi by lazy {
        retrofit.create(WeatherApi::class.java)
    }
}