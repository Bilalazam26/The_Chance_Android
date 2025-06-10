package com.thechance.weatherapp.weather.domain.location

import com.thechance.weatherapp.weather.domain.location.model.LocationCoordinate

interface LocationProvider {
    suspend fun getCurrentLocation(): Result<LocationCoordinate>
}