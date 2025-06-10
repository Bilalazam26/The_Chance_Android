package com.thechance.weatherapp.weather.data.location

import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.thechance.weatherapp.core.data.exception.LocationFailureException
import com.thechance.weatherapp.core.data.exception.LocationPermissionException
import com.thechance.weatherapp.core.data.utils.hasLocationPermission
import com.thechance.weatherapp.weather.domain.location.LocationProvider
import com.thechance.weatherapp.weather.domain.location.model.LocationCoordinate
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class GoogleLocationServiceProvider(
    private val locationClient: FusedLocationProviderClient,
    private val application: Application
) : LocationProvider {
    @androidx.annotation.RequiresPermission(allOf = [android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION])
    override suspend fun getCurrentLocation(): Result<LocationCoordinate> {
        if (!hasLocationPermission(application)) {
            return Result.failure(LocationPermissionException())
        }

        return suspendCancellableCoroutine { continuation ->
            locationClient.lastLocation.apply {
                if (isComplete) {
                    if (isSuccessful) {
                        continuation.resume(
                            Result.success(
                                LocationCoordinate(
                                    latitude = result.latitude,
                                    longitude = result.longitude
                                )
                            )
                        )
                    } else {
                        continuation.resume(
                            Result.failure(
                                LocationFailureException()
                            )
                        )
                    }
                    return@suspendCancellableCoroutine
                }
                addOnSuccessListener {
                    if (it == null) {
                        continuation.resume(
                            Result.failure(
                                LocationFailureException()
                            )
                        )
                        return@addOnSuccessListener
                    }
                    continuation.resume(
                        Result.success(
                            LocationCoordinate(
                                latitude = it.latitude,
                                longitude = it.longitude
                            )
                        )
                    )
                }
                addOnFailureListener {
                    continuation.resume(
                        Result.failure(
                            LocationFailureException()
                        )
                    )
                }
                addOnCanceledListener {
                    continuation.cancel()
                }
            }
        }
    }
}