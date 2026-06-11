package com.kingstudio.weatherforecast.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kingstudio.weatherforecast.R
import com.kingstudio.weatherforecast.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        binding.button.setOnClickListener {

            val locationName = binding.edtLocationName.text.toString().trim()

            if(locationName.isBlank()){

                binding.edtLocationName.error = "Enter location name"
                return@setOnClickListener
            }

            viewModel.searchWeather(locationName)
        }

        observeUiState()
    }

    private fun observeUiState(){

        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.STARTED){

                viewModel.uiState.collect { state ->

                    when(state){

                        is WeatherUiState.Idle -> {
                            binding.textView.text = "Enter a location name to get weather"
                            binding.button.isEnabled = true
                            binding.button.text = "Search"
                        }

                        is WeatherUiState.Loading -> {

                            binding.textView.text = "Fetching weather..."
                            binding.button.isEnabled = false
                            binding.button.text = "Searching..."

                        }

                        is WeatherUiState.Success -> {

                            val d = state.data

                            val weatherText = getString(
                                R.string.weather_info,
                                d.cityName,
                                d.tempC,
                                d.tempF,
                                d.condition,
                                d.windSpeed,
                                d.time
                            )

                            binding.textView.text = weatherText
                            binding.button.isEnabled = true
                            binding.button.text = "Search"

                        }

                        is WeatherUiState.Error -> {

                            binding.textView.text = getString(R.string.error_message, state.message)
                            binding.button.isEnabled = true
                            binding.button.text = "Search"
                        }

                    }
                }

            }

        }
    }
}