package com.kingstudio.weatherforecast.ui.model

data class WeatherDisplayData(

    val cityName: String,
    val tempC: Double,
    val tempF: Double,
    val condition: String,
    val windSpeed: Double,
    val time: String
)
