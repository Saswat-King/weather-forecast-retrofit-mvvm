package com.kingstudio.weatherforecast.ui

import com.kingstudio.weatherforecast.ui.model.WeatherDisplayData

sealed class WeatherUiState {

    object Idle : WeatherUiState()
    object Loading : WeatherUiState()


    data class Success(val data: WeatherDisplayData) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}