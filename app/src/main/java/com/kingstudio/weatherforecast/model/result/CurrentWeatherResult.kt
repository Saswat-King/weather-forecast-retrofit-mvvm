package com.kingstudio.weatherforecast.model.result

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResult(


    val time: String,
    val interval: Int,
    val temperature: Double,


    @SerializedName("windspeed")
    val windSpeed: Double,

    @SerializedName("winddirection")
    val windDirection: Int,

    @SerializedName("is_day")
    val isDay: Int,

    @SerializedName("weathercode")
    val weatherCode: Int
)
