package com.thechance.weatherapp.weather.ui.sections

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.thechance.weatherapp.weather.domain.weather.model.DailyWeatherData
import com.thechance.weatherapp.weather.ui.components.DailyWeatherCard

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NextWeekWeatherSection(modifier: Modifier = Modifier, dailyWeather: List<DailyWeatherData>) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(MaterialTheme.shapes.large)
            .background(MaterialTheme.colorScheme.surface.copy(alpha = .7f))
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = .08f),
                shape = MaterialTheme.shapes.large
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),

        ) {
            Spacer(modifier = Modifier.height(12.dp))
            dailyWeather.forEachIndexed { index, dailyWeatherData  ->
                DailyWeatherCard(
                    dailyWeather = dailyWeatherData,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                )
                if (index < dailyWeather.size - 1) {
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth(),
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = .08f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

        }


    }

}