package com.thechance.weatherapp.weather.data.weather


import android.os.Build
import androidx.annotation.RequiresApi
import com.thechance.weatherapp.core.data.utils.toDate
import com.thechance.weatherapp.weather.data.weather.datasource.remote.RemoteWeatherDataSource
import com.thechance.weatherapp.weather.data.weather.datasource.remote.mapper.toCurrentWeatherData
import com.thechance.weatherapp.weather.data.weather.datasource.remote.mapper.toList
import com.thechance.weatherapp.weather.domain.location.model.LocationCoordinate
import com.thechance.weatherapp.weather.domain.weather.WeatherRepository
import com.thechance.weatherapp.weather.domain.weather.model.CurrentWeatherData
import com.thechance.weatherapp.weather.domain.weather.model.DailyWeatherData
import com.thechance.weatherapp.weather.domain.weather.model.HourlyWeatherData
import java.time.LocalDate

class WeatherRepositoryImpl(
    private val remoteWeatherDataSource: RemoteWeatherDataSource
) : WeatherRepository {
    override suspend fun getCurrentWeatherData(locationCoordinate: LocationCoordinate): Result<Map<String, CurrentWeatherData>> {
        return remoteWeatherDataSource.getCurrentWeatherData(locationCoordinate).map {
            it.mapValues { entry ->
                entry.value.toCurrentWeatherData()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getHourlyWeatherData(
        locationCoordinate: LocationCoordinate,
        endDate: LocalDate
    ): Result<List<HourlyWeatherData>> {
        return remoteWeatherDataSource.getHourlyWeatherData(locationCoordinate, endDate.toDate()).map {
            it.toList()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getDailyWeatherData(locationCoordinate: LocationCoordinate): Result<List<DailyWeatherData>> {
        return remoteWeatherDataSource.getDailyWeatherData(locationCoordinate).map {
            it.toList()
        }
    }
}