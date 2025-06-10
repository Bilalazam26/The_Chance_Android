package com.thechance.weatherapp.weather_feature.ui.screen.weather

import android.os.Build
import androidx.annotation.RequiresApi
import com.thechance.weatherapp.weather_feature.domain.location.model.LocationCoordinate
import com.thechance.weatherapp.weather_feature.domain.weather.model.CurrentWeatherData
import com.thechance.weatherapp.weather_feature.domain.weather.model.DailyWeatherData
import com.thechance.weatherapp.weather_feature.domain.weather.model.HourlyWeatherData
@RequiresApi(Build.VERSION_CODES.O)
data class WeatherUiState (
    val location: LocationCoordinate = LocationCoordinate(),
    val city: String = "Damietta",
    val currentWeather: CurrentWeatherData = CurrentWeatherData(),
    val dailyWeather: List<DailyWeatherData> =  listOf(DailyWeatherData()),
    val hourlyWeather: List<HourlyWeatherData> = listOf(HourlyWeatherData()),
    val isLoading: Boolean = true,
    val isRefreshing: Boolean = false,
    val error: String? = null
)