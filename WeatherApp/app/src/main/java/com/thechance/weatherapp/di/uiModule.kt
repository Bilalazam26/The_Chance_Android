package com.thechance.weatherapp.di

import com.thechance.weatherapp.weather.ui.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::WeatherViewModel)
}