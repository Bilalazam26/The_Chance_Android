package com.thechance.weatherapp.weather.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thechance.weatherapp.weather.domain.location.GetLocationUseCase
import com.thechance.weatherapp.weather.domain.weather.usecases.WeatherUseCases
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
class WeatherViewModel(
    private val weatherUseCases: WeatherUseCases,
    private val locationUseCase: GetLocationUseCase
): ViewModel() {
    var weatherUiState by mutableStateOf(WeatherUiState())
    private set


    suspend fun getLocation() = viewModelScope.launch {
        weatherUiState = weatherUiState.copy(
            isLoading = false
        )
        locationUseCase()
            .onSuccess {
                weatherUiState = weatherUiState.copy(
                    location = it,
                    isLoading = false
                )
                getCurrentWeather()
                getDailyWeather()
                getHourlyWeather()
            }
            .onFailure {
                weatherUiState = weatherUiState.copy(
                    error = it.message,
                    isLoading = false
                )
            }
    }

    suspend fun getCurrentWeather() = viewModelScope.launch {
        weatherUiState = weatherUiState.copy(
            isLoading = false
        )
        weatherUseCases.getCurrentWeatherUseCase(weatherUiState.location)
            .onSuccess {
                weatherUiState = weatherUiState.copy(
                    currentWeather = it,
                    isLoading = false
                )
            }
            .onFailure {
                weatherUiState = weatherUiState.copy(
                    error = it.message,
                    isLoading = false
                )
            }
    }

    private suspend fun getHourlyWeather() = viewModelScope.launch {
        weatherUiState = weatherUiState.copy(
            isLoading = false
        )
        weatherUseCases.getHourlyWeatherUseCase(weatherUiState.location)
            .onSuccess {
                weatherUiState = weatherUiState.copy(
                    hourlyWeather = it,
                    isLoading = false
                )
            }
            .onFailure {
                weatherUiState = weatherUiState.copy(
                    error = it.message,
                    isLoading = false
                )
            }
    }

    private suspend fun getDailyWeather() = viewModelScope.launch {
        weatherUiState = weatherUiState.copy(
            isLoading = false
        )
        weatherUseCases.getDailyWeatherUseCase(weatherUiState.location)
            .onSuccess {
                weatherUiState = weatherUiState.copy(
                    dailyWeather = it,
                    isLoading = false
                )
            }
            .onFailure {
                weatherUiState = weatherUiState.copy(
                    error = it.message,
                    isLoading = false
                )
            }
    }

}