package com.thechance.weatherapp.weather.domain.weather.usecases

import com.thechance.weatherapp.weather.domain.location.model.LocationCoordinate
import com.thechance.weatherapp.weather.domain.weather.WeatherRepository
import com.thechance.weatherapp.weather.domain.weather.model.DailyWeatherData

class GetDailyWeatherUseCase(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(locationCoordinate: LocationCoordinate): Result<List<DailyWeatherData>> {
        return weatherRepository.getDailyWeatherData(locationCoordinate)
    }
}