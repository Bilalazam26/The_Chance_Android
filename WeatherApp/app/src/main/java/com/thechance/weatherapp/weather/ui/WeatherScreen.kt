package com.thechance.weatherapp.weather.ui

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.weatherapp.R
import com.thechance.weatherapp.core.ui.theme.WeatherAppTheme
import com.thechance.weatherapp.weather.domain.weather.model.DailyWeatherData
import com.thechance.weatherapp.weather.domain.weather.model.HourlyWeatherData
import com.thechance.weatherapp.weather.ui.components.MinMaxTempContainer
import com.thechance.weatherapp.weather.ui.sections.CurrentWeatherSection
import com.thechance.weatherapp.weather.ui.sections.NextWeekWeatherSection
import com.thechance.weatherapp.weather.ui.sections.TodayWeatherSection
import java.time.LocalDate
import java.time.LocalDateTime


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    //viewModel: WeatherViewModel = koinViewModel()
) {/*
    val city = viewModel.weatherUiState.currentWeather.keys.first()
    val currentWeather = viewModel.weatherUiState.currentWeather.values.first()
    val dailyWeather = viewModel.weatherUiState.dailyWeather
    val hourlyWeather = viewModel.weatherUiState.hourlyWeather*/

    val scrollState = rememberScrollState()
    val scrollOffset = scrollState.value.coerceAtMost(50)

    // Animation progress: 0f to 1f
    val progress = (scrollOffset / 50f).coerceIn(0f, 1f)

    // Weather image animation
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp

    val maxImageWidth = screenWidthDp - 128.dp
    val maxImageHeight = (maxImageWidth / 1.35f)
    val minImageWidth = screenWidthDp - 24.dp - 168.dp
    val minImageHeight = (minImageWidth / 1.35f)

    val imageWidth by animateDpAsState(targetValue = maxImageWidth - (maxImageWidth - minImageWidth) * progress)
    val imageHeight by animateDpAsState(targetValue = maxImageHeight - (maxImageHeight - minImageHeight) * progress)


//val imageScale by animateFloatAsState(targetValue = 1f - 0.4f * progress, label = "imageScale")
    val imageOffsetX by animateDpAsState(
        targetValue = (0.dp - 120.dp * progress) + 12.dp,
        label = "imageOffsetX"
    )
    val imageOffsetY by animateDpAsState(
        targetValue = 0.dp - 100.dp * progress,
        label = "imageOffsetY"
    )

    val infoOffsetX by animateDpAsState(
        targetValue = (0.dp + 120.dp * progress) - 12.dp,
        label = "infoOffsetX"
    )
    val infoOffsetY by animateDpAsState(
        targetValue = -imageHeight * progress,
        label = "infoOffsetY"
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .clipToBounds(),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(it)
                .verticalScroll(scrollState)
                .clipToBounds(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .graphicsLayer {
                        translationY = infoOffsetY.toPx()
                        clip = true
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.location_ic),
                    contentDescription = "location",
                    tint = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "city",
                    modifier = Modifier,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }


            Image(
                painter = painterResource(id = R.drawable.mainly_clear),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .shadow(
                        elevation = 150.dp,
                        spotColor = MaterialTheme.colorScheme.surfaceVariant,
                        ambientColor = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape,
                        clip = false
                    )
                    .width(imageWidth)
                    .height(imageHeight)
                    .graphicsLayer {
                        translationX = imageOffsetX.toPx()
                        clip = true
                    }
            )

            Column(
                modifier = Modifier
                    .width(168.dp)
                    .graphicsLayer {
                        translationX = infoOffsetX.toPx()
                        translationY = infoOffsetY.toPx()
                        clip = true
                    }
                    .padding(vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "26°C",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = "Partly Cloudy",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = .6f)
                )

                Spacer(modifier = Modifier.height(12.dp))

                MinMaxTempContainer(
                    minTemp = 19.0,
                    maxTemp = 28.0,
                    modifier = Modifier
                        .heightIn(max = 35.dp)
                )

            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        translationY = infoOffsetY.toPx()
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CurrentWeatherSection(
                    currentWeatherAttributes = listOf<WeatherAttribute>(
                        WeatherAttribute(
                            attrName = "Wind",
                            attrValue = "10",
                            attrMeasureUnit = "km/h",
                            iconResource = R.drawable.wind_speed_ic
                        ),
                        WeatherAttribute(
                            attrName = "Humidity",
                            attrValue = "50",
                            attrMeasureUnit = "%",
                            iconResource = R.drawable.humidity_ic
                        ),
                        WeatherAttribute(
                            attrName = "Rain",
                            attrValue = "2",
                            attrMeasureUnit = "%",
                            iconResource = R.drawable.rain_ic
                        ),
                        WeatherAttribute(
                            attrName = "UV Index",
                            attrValue = "2",
                            attrMeasureUnit = "",
                            iconResource = R.drawable.uv_ic
                        ),
                        WeatherAttribute(
                            attrName = "Pressure",
                            attrValue = "1012",
                            attrMeasureUnit = "hPa",
                            iconResource = R.drawable.pressure_ic
                        ),
                        WeatherAttribute(
                            attrName = "Feels Like",
                            attrValue = "22",
                            attrMeasureUnit = "°C",
                            iconResource = R.drawable.feels_like_ic
                        )
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                )

                TodayWeatherSection(
                    modifier = Modifier
                        .fillMaxWidth(),
                    todayWeather = listOf(
                        HourlyWeatherData(
                            hour = LocalDateTime.parse("2025-06-09T12:00"),
                            temperature = 29.0,
                            condition = "Clear sky"
                        ),
                        HourlyWeatherData(
                            hour = LocalDateTime.parse("2025-06-09T12:00"),
                            temperature = 29.0,
                            condition = "Clear sky"
                        ),
                        HourlyWeatherData(
                            hour = LocalDateTime.parse("2025-06-09T12:00"),
                            temperature = 29.0,
                            condition = "Clear sky"
                        ),
                        HourlyWeatherData(
                            hour = LocalDateTime.parse("2025-06-09T12:00"),
                            temperature = 29.0,
                            condition = "Clear sky"
                        ),
                        HourlyWeatherData(
                            hour = LocalDateTime.parse("2025-06-09T12:00"),
                            temperature = 29.0,
                            condition = "Clear sky"
                        ),
                        HourlyWeatherData(
                            hour = LocalDateTime.parse("2025-06-09T12:00"),
                            temperature = 29.0,
                            condition = "Clear sky"
                        ),
                        HourlyWeatherData(
                            hour = LocalDateTime.parse("2025-06-09T12:00"),
                            temperature = 29.0,
                            condition = "Clear sky"
                        ),
                        HourlyWeatherData(
                            hour = LocalDateTime.parse("2025-06-09T12:00"),
                            temperature = 29.0,
                            condition = "Clear sky"
                        ),
                        HourlyWeatherData(
                            hour = LocalDateTime.parse("2025-06-09T12:00"),
                            temperature = 29.0,
                            condition = "Clear sky"
                        ),
                        HourlyWeatherData(
                            hour = LocalDateTime.parse("2025-06-09T12:00"),
                            temperature = 29.0,
                            condition = "Clear sky"
                        ),
                        HourlyWeatherData(
                            hour = LocalDateTime.parse("2025-06-09T12:00"),
                            temperature = 29.0,
                            condition = "Clear sky"
                        )
                    )
                )

                NextWeekWeatherSection(
                    dailyWeather = listOf(
                        DailyWeatherData(
                            date = LocalDate.parse("2025-06-09"),
                            minTemperature = 29.0,
                            maxTemperature = 35.0,
                            condition = "Clear sky"
                        ),
                        DailyWeatherData(
                            date = LocalDate.parse("2025-06-09"),
                            minTemperature = 29.0,
                            maxTemperature = 35.0,
                            condition = "Clear sky"
                        ),
                        DailyWeatherData(
                            date = LocalDate.parse("2025-06-09"),
                            minTemperature = 29.0,
                            maxTemperature = 35.0,
                            condition = "Clear sky"
                        ),
                        DailyWeatherData(
                            date = LocalDate.parse("2025-06-09"),
                            minTemperature = 29.0,
                            maxTemperature = 35.0,
                            condition = "Clear sky"
                        ),
                        DailyWeatherData(
                            date = LocalDate.parse("2025-06-09"),
                            minTemperature = 29.0,
                            maxTemperature = 35.0,
                            condition = "Clear sky"
                        ),
                        DailyWeatherData(
                            date = LocalDate.parse("2025-06-09"),
                            minTemperature = 29.0,
                            maxTemperature = 35.0,
                            condition = "Clear sky"
                        ),
                        DailyWeatherData(
                            date = LocalDate.parse("2025-06-09"),
                            minTemperature = 29.0,
                            maxTemperature = 35.0,
                            condition = "Clear sky"
                        )
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}
/*
val maxImageWidth = screenWidthDp - 128.dp
val maxImageHeight = (maxImageWidth / 1.35f)
val minImageWidth = screenWidthDp - 24.dp - 168.dp
val minImageHeight = (minImageWidth / 1.35f)

val imageWidth by animateDpAsState(targetValue = maxImageWidth - (maxImageWidth - minImageWidth) * progress)
val imageHeight by animateDpAsState(targetValue = maxImageHeight - (maxImageHeight - minImageHeight) * progress)


//val imageScale by animateFloatAsState(targetValue = 1f - 0.4f * progress, label = "imageScale")
val imageOffsetX by animateDpAsState(
    targetValue = (0.dp - 120.dp * progress) + 12.dp,
    label = "imageOffsetX"
)
val imageOffsetY by animateDpAsState(
    targetValue = 0.dp - 100.dp * progress,
    label = "imageOffsetY"
)

val infoOffsetX by animateDpAsState(
    targetValue = (imageWidth * progress),
    label = "infoOffsetX"
)
val infoOffsetY by animateDpAsState(
    targetValue = (imageHeight - imageHeight * progress) - 12.dp,
    label = "infoOffsetY"
)

Scaffold(
modifier = Modifier
.fillMaxSize(),
containerColor = MaterialTheme.colorScheme.background
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(it)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.location_ic),
                contentDescription = "location",
                tint = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = "city",
                modifier = Modifier,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .graphicsLayer {
                    translationX = imageOffsetX.toPx()
                    translationY = imageOffsetY.toPx()
                }
                .height(imageHeight + 167.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.mainly_clear),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(imageWidth, imageHeight)
                    .shadow(
                        elevation = 150.dp,
                        spotColor = MaterialTheme.colorScheme.surfaceVariant,
                        ambientColor = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape,
                        clip = false
                    )
                    .align(Alignment.TopCenter)
            )

            Column(
                modifier = Modifier
                    .width(168.dp)
                    .padding(vertical = 12.dp)
                    .graphicsLayer {
                        translationX = infoOffsetX.toPx()
                        translationY = infoOffsetY.toPx()
                    }
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "26°C",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = "Partly Cloudy",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = .6f)
                )

                Spacer(modifier = Modifier.height(12.dp))

                MinMaxTempContainer(
                    minTemp = 19.0,
                    maxTemp = 28.0,
                    modifier = Modifier
                        .heightIn(max = 35.dp)
                )

            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CurrentWeatherSection(
                currentWeatherAttributes = listOf<WeatherAttribute>(
                    WeatherAttribute(
                        attrName = "Wind",
                        attrValue = "10",
                        attrMeasureUnit = "km/h",
                        iconResource = R.drawable.wind_speed_ic
                    ),
                    WeatherAttribute(
                        attrName = "Humidity",
                        attrValue = "50",
                        attrMeasureUnit = "%",
                        iconResource = R.drawable.humidity_ic
                    ),
                    WeatherAttribute(
                        attrName = "Rain",
                        attrValue = "2",
                        attrMeasureUnit = "%",
                        iconResource = R.drawable.rain_ic
                    ),
                    WeatherAttribute(
                        attrName = "UV Index",
                        attrValue = "2",
                        attrMeasureUnit = "",
                        iconResource = R.drawable.uv_ic
                    ),
                    WeatherAttribute(
                        attrName = "Pressure",
                        attrValue = "1012",
                        attrMeasureUnit = "hPa",
                        iconResource = R.drawable.pressure_ic
                    ),
                    WeatherAttribute(
                        attrName = "Feels Like",
                        attrValue = "22",
                        attrMeasureUnit = "°C",
                        iconResource = R.drawable.feels_like_ic
                    )
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            )

            TodayWeatherSection(
                modifier = Modifier
                    .fillMaxWidth(),
                todayWeather = listOf(
                    HourlyWeatherData(
                        hour = LocalDateTime.parse("2025-06-09T12:00"),
                        temperature = 29.0,
                        condition = "Clear sky"
                    ),
                    HourlyWeatherData(
                        hour = LocalDateTime.parse("2025-06-09T12:00"),
                        temperature = 29.0,
                        condition = "Clear sky"
                    ),
                    HourlyWeatherData(
                        hour = LocalDateTime.parse("2025-06-09T12:00"),
                        temperature = 29.0,
                        condition = "Clear sky"
                    ),
                    HourlyWeatherData(
                        hour = LocalDateTime.parse("2025-06-09T12:00"),
                        temperature = 29.0,
                        condition = "Clear sky"
                    ),
                    HourlyWeatherData(
                        hour = LocalDateTime.parse("2025-06-09T12:00"),
                        temperature = 29.0,
                        condition = "Clear sky"
                    ),
                    HourlyWeatherData(
                        hour = LocalDateTime.parse("2025-06-09T12:00"),
                        temperature = 29.0,
                        condition = "Clear sky"
                    ),
                    HourlyWeatherData(
                        hour = LocalDateTime.parse("2025-06-09T12:00"),
                        temperature = 29.0,
                        condition = "Clear sky"
                    ),
                    HourlyWeatherData(
                        hour = LocalDateTime.parse("2025-06-09T12:00"),
                        temperature = 29.0,
                        condition = "Clear sky"
                    ),
                    HourlyWeatherData(
                        hour = LocalDateTime.parse("2025-06-09T12:00"),
                        temperature = 29.0,
                        condition = "Clear sky"
                    ),
                    HourlyWeatherData(
                        hour = LocalDateTime.parse("2025-06-09T12:00"),
                        temperature = 29.0,
                        condition = "Clear sky"
                    ),
                    HourlyWeatherData(
                        hour = LocalDateTime.parse("2025-06-09T12:00"),
                        temperature = 29.0,
                        condition = "Clear sky"
                    )
                )
            )

            NextWeekWeatherSection(
                dailyWeather = listOf(
                    DailyWeatherData(
                        date = LocalDate.parse("2025-06-09"),
                        minTemperature = 29.0,
                        maxTemperature = 35.0,
                        condition = "Clear sky"
                    ),
                    DailyWeatherData(
                        date = LocalDate.parse("2025-06-09"),
                        minTemperature = 29.0,
                        maxTemperature = 35.0,
                        condition = "Clear sky"
                    ),
                    DailyWeatherData(
                        date = LocalDate.parse("2025-06-09"),
                        minTemperature = 29.0,
                        maxTemperature = 35.0,
                        condition = "Clear sky"
                    ),
                    DailyWeatherData(
                        date = LocalDate.parse("2025-06-09"),
                        minTemperature = 29.0,
                        maxTemperature = 35.0,
                        condition = "Clear sky"
                    ),
                    DailyWeatherData(
                        date = LocalDate.parse("2025-06-09"),
                        minTemperature = 29.0,
                        maxTemperature = 35.0,
                        condition = "Clear sky"
                    ),
                    DailyWeatherData(
                        date = LocalDate.parse("2025-06-09"),
                        minTemperature = 29.0,
                        maxTemperature = 35.0,
                        condition = "Clear sky"
                    ),
                    DailyWeatherData(
                        date = LocalDate.parse("2025-06-09"),
                        minTemperature = 29.0,
                        maxTemperature = 35.0,
                        condition = "Clear sky"
                    )
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
*/

@RequiresApi(Build.VERSION_CODES.O)
@Preview(
    showBackground = true, showSystemUi = true, device = "id:pixel_5",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun WeatherScreenNightPreview() {
    WeatherAppTheme {
        WeatherScreen()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(
    showBackground = true, showSystemUi = true, device = "id:pixel_5"
)
@Composable
fun WeatherScreenPreview() {
    WeatherAppTheme {
        WeatherScreen()
    }
}