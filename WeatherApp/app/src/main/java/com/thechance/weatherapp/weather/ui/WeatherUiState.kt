package com.thechance.weatherapp.weather.ui

import android.os.Build
import androidx.annotation.RequiresApi
import com.thechance.weatherapp.weather.domain.location.model.LocationCoordinate
import com.thechance.weatherapp.weather.domain.weather.model.CurrentWeatherData
import com.thechance.weatherapp.weather.domain.weather.model.DailyWeatherData
import com.thechance.weatherapp.weather.domain.weather.model.HourlyWeatherData
@RequiresApi(Build.VERSION_CODES.O)
data class WeatherUiState (
    val location: LocationCoordinate = LocationCoordinate(),
    val currentWeather: Map<String, CurrentWeatherData> = mapOf("" to CurrentWeatherData()),
    val dailyWeather: List<DailyWeatherData> =  listOf(DailyWeatherData()),
    val hourlyWeather: List<HourlyWeatherData> = listOf(HourlyWeatherData()),
    val isLoading: Boolean = false,
    val error: String? = null
)