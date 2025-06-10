package com.thechance.weatherapp.weather.domain.weather.model

data class CurrentWeatherData(
    val temperature: Double = 0.0,
    val condition: String = "",
    val feelsLike: Double = 0.0,
    val humidity: Int = 0,
    val windSpeed: Double = 0.0,
    val rain: Double = 0.0,
    val isDay: Boolean = true
)