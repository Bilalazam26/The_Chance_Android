package com.thechance.weatherapp.weather.ui

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
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

    val blurColor = MaterialTheme.colorScheme.surfaceVariant
    val density = LocalDensity.current

    val scrollState = rememberScrollState()
    val scrollOffset = scrollState.value.coerceAtMost(50)

    val progress = (scrollOffset / 50f).coerceIn(0f, 1f)

    // Weather image animation
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp

    val maxImageWidth = screenWidthDp - 128.dp
    val maxImageHeight = (maxImageWidth / 1.35f)
    val minImageWidth = 136.dp
    val minImageHeight = (minImageWidth / 1.35f)

    val imageWidth by animateDpAsState(targetValue = maxImageWidth - (maxImageWidth - minImageWidth) * progress)
    val imageHeight by animateDpAsState(targetValue = maxImageHeight - (maxImageHeight - minImageHeight) * progress)


    val imageOffsetX by animateDpAsState(
        targetValue = (0.dp - 120.dp * progress) + (12.dp * progress),
        tween(
            durationMillis = 500,
            easing = LinearOutSlowInEasing
        )
    )
    val infoOffsetX by animateDpAsState(
        targetValue = (0.dp + 120.dp * progress) - (12.dp * progress),
        tween(
            durationMillis = 500,
            easing = LinearOutSlowInEasing
        )
    )
    val infoOffsetY by animateDpAsState(
        targetValue = -(imageHeight - 24.dp) * progress,
        tween(
            durationMillis = 500,
            easing = LinearOutSlowInEasing
        )
    )

    val initialHeaderHeight = maxImageHeight + 24.dp + 60.dp + 168.dp
    val headerHeight by animateDpAsState(
        targetValue = initialHeaderHeight - (((maxImageHeight - 136.dp) + 180.dp) * progress),
        tween(
            durationMillis = 500,
            easing = LinearOutSlowInEasing
        )
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .clipToBounds(),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        ConstraintLayout(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(it)
                .verticalScroll(scrollState)
                .clipToBounds(),
        ) {
            val (header, content) = createRefs()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(headerHeight)
                    .constrainAs(header) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .height(24.dp),
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
                        .width(imageWidth)
                        .height(imageHeight)
                        .graphicsLayer {
                            translationX = imageOffsetX.toPx()
                            spotShadowColor = blurColor
                            ambientShadowColor = blurColor
                            shape = CircleShape
                            shadowElevation = with(density) { 150.dp.toPx() }
                        }
                )

                Column(
                    modifier = Modifier
                        .width(168.dp)
                        .wrapContentHeight(unbounded = true)
                        .graphicsLayer {
                            translationX = infoOffsetX.toPx()
                        }
                        .offset(y = infoOffsetY)
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
            }


            Column(
                modifier = Modifier
                    .constrainAs(content) {
                        top.linkTo(header.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
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
}

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