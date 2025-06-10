package com.thechance.weatherapp.core.ui.utils

import com.thechance.weatherapp.R

fun weatherConditionToImage(condition: String): Int {
    return when (condition) {
        "Clear sky" -> R.drawable.clear_sky
        "Mainly clear" -> R.drawable.mainly_clear
        "Partly cloudy" -> R.drawable.partly_cloudy
        "Overcast" -> R.drawable.overcast
        "Fog" -> R.drawable.fog
        "Depositing rime fog" -> R.drawable.depositing_rime_fog
        "Light drizzle" -> R.drawable.drizzle_light
        "Moderate drizzle" -> R.drawable.drizzle_moderate
        "Dense drizzle" -> R.drawable.drizzle_intensity
        "Light freezing drizzle" -> R.drawable.freezing_drizzle_light
        "Dense freezing drizzle" -> R.drawable.freezing_drizzle_intensity
        "Slight rain" -> R.drawable.rain_slight
        "Moderate rain" -> R.drawable.rain_moderate
        "Heavy rain" -> R.drawable.rain_intensity
        "Light freezing rain" -> R.drawable.freezing_light
        "Heavy freezing rain" -> R.drawable.freezing_heavy
        "Slight snow fall" -> R.drawable.rain_slight
        "Moderate snow fall" -> R.drawable.snow_fall_moderate
        "Heavy snow fall" -> R.drawable.snow_fall_intensity
        "Snow grains" -> R.drawable.snow_grains
        "Slight rain showers" -> R.drawable.rain_shower_slight
        "Moderate rain showers" -> R.drawable.rain_shower_moderate
        "Violent rain showers" -> R.drawable.rain_shower_violent
        "Slight snow showers" -> R.drawable.snow_shower_slight
        "Heavy snow showers" -> R.drawable.snow_shower_heavy
        "Thunderstorm" -> R.drawable.thunderstrom_slight_or_moderate
        "Thunderstorm with slight hail" -> R.drawable.thunderstrom_with_slight_hail
        "Thunderstorm with heavy hail" -> R.drawable.thunderstrom_with_heavy_hail
        else -> R.drawable.mainly_clear
    }
}