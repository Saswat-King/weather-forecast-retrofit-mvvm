package com.kingstudio.weatherforecast.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kingstudio.weatherforecast.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel()
{
    private val repository = WeatherRepository()

    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Idle)

    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()


    fun searchWeather(cityName: String){

        viewModelScope.launch {


            _uiState.value = WeatherUiState.Loading

            try {

                val weatherData = repository.fetchWeather(cityName)

                _uiState.value = WeatherUiState.Success(weatherData)


            } catch (e: Exception) {

                _uiState.value = WeatherUiState.Error(e.message ?: "Something went wrong")
            }
        }
    }

}