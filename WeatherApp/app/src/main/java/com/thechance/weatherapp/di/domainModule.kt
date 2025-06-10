package com.thechance.weatherapp.di

import com.thechance.weatherapp.weather.domain.location.GetLocationUseCase
import com.thechance.weatherapp.weather.domain.weather.usecases.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::GetLocationUseCase)

    singleOf(::GetCurrentWeatherUseCase)
    singleOf(::GetDailyWeatherUseCase)
    singleOf(::GetHourlyWeatherUseCase)

    singleOf(::WeatherUseCases)
}