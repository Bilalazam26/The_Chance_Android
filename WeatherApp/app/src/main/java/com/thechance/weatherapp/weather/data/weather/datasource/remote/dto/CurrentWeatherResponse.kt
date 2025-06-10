package com.thechance.weatherapp.weather.data.weather.datasource.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponse(
    val current: CurrentWeatherDto,
    val timezone: String
)
