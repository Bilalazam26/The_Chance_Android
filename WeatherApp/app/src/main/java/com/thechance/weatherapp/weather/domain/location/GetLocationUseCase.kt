package com.thechance.weatherapp.weather.domain.location

import com.thechance.weatherapp.weather.domain.location.model.LocationCoordinate

class GetLocationUseCase(
    private val locationProvider: LocationProvider
) {
    suspend operator fun invoke(): Result<LocationCoordinate> = locationProvider.getCurrentLocation()
}