package com.kingstudio.weatherforecast.repository

import com.kingstudio.weatherforecast.network.GeocodingClient
import com.kingstudio.weatherforecast.network.WeatherClient
import com.kingstudio.weatherforecast.ui.model.WeatherDisplayData

class WeatherRepository {


    suspend fun fetchWeather(cityName: String): WeatherDisplayData{

        val geoResponse = GeocodingClient.api.getLocation(cityName)

        val firstResult = geoResponse.results?.firstOrNull()
            ?: throw Exception("City not found. Please check the spelling.")

        val latitude = firstResult.latitude
        val longitude = firstResult.longitude

        val weatherResponse = WeatherClient.api.getWeather(latitude,longitude)

        val weather = weatherResponse.currentWeather ?: throw Exception("Weather data unavailable")

        val tempf = (weather.temperature * 9.0/5.0) + 32

        val condition = getWeatherCondition(weather.weatherCode)


        return WeatherDisplayData(
            cityName = firstResult.name,
            tempC = weather.temperature,
            tempF = tempf,
            condition = condition,
            windSpeed = weather.windSpeed,
            time = weather.time
        )
    }

    private fun getWeatherCondition(code: Int) : String = when(code){

        0           -> "Clear Sky ☀️"
        in 1..3     -> "Cloudy ☁️"
        in 45..48   -> "Fog 🌫️"
        in 51..67   -> "Rain 🌧️"
        in 71..77   -> "Snow 🌨️"
        in 80..82   -> "Rain Showers 🌦️"
        in 95..99   -> "Thunderstorm ⛈️"
        else        -> "Unknown 🌡️"
    }
}