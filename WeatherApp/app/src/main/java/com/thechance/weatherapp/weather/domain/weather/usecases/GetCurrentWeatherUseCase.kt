package com.thechance.weatherapp.weather.domain.weather.usecases

import com.thechance.weatherapp.weather.domain.location.model.LocationCoordinate
import com.thechance.weatherapp.weather.domain.weather.WeatherRepository
import com.thechance.weatherapp.weather.domain.weather.model.CurrentWeatherData

class GetCurrentWeatherUseCase(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(locationCoordinate: LocationCoordinate): Result<Map<String, CurrentWeatherData>> {
        return weatherRepository.getCurrentWeatherData(locationCoordinate)
    }
}