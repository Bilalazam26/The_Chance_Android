package com.thechance.weatherapp.weather.domain.weather.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
data class HourlyWeatherData (
    val hour: LocalDateTime? = LocalDateTime.now(),
    val temperature: Double = 0.0,
    val condition: String = ""
)
