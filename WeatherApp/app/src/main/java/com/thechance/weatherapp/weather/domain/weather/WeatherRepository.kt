package com.thechance.weatherapp.weather.domain.weather

import com.thechance.weatherapp.weather.domain.location.model.LocationCoordinate
import com.thechance.weatherapp.weather.domain.weather.model.CurrentWeatherData
import com.thechance.weatherapp.weather.domain.weather.model.DailyWeatherData
import com.thechance.weatherapp.weather.domain.weather.model.HourlyWeatherData
import java.time.LocalDate
import java.time.LocalDateTime

interface WeatherRepository {
    suspend fun getCurrentWeatherData(
        locationCoordinate: LocationCoordinate
    ): Result<Map<String, CurrentWeatherData>>

    suspend fun getHourlyWeatherData(
        locationCoordinate: LocationCoordinate,
        endDate: LocalDate
    ): Result<List<HourlyWeatherData>>

    suspend fun getDailyWeatherData(
        locationCoordinate: LocationCoordinate
    ): Result<List<DailyWeatherData>>
}