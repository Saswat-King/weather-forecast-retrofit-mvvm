package com.kingstudio.weatherforecast.model.response

import com.google.gson.annotations.SerializedName
import com.kingstudio.weatherforecast.model.result.CurrentWeatherResult

data class WeatherResponse(

    @SerializedName("current_weather")
    val currentWeather: CurrentWeatherResult?
)
