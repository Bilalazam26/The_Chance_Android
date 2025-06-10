package com.thechance.weatherapp.core.ui.themeswitch

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.thechance.weatherapp.core.ui.themeswitch.components.Clouds
import com.thechance.weatherapp.core.ui.themeswitch.components.Moon
import com.thechance.weatherapp.core.ui.themeswitch.components.NightSkyBackground
import com.thechance.weatherapp.core.ui.theme.WeatherAppTheme

@Composable
fun ThemeSwitcher(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = false,
    switchSize: Dp = 150.dp,
    padding: Dp = 4.dp,
    animationSpec: AnimationSpec<Dp> = tween(durationMillis = 1000),
    onClick: () -> Unit
) {
    val offset by animateDpAsState(
        targetValue = if (isDarkTheme) switchSize / 2 else 0.dp,
        animationSpec = animationSpec
    )

    Box(
        modifier = modifier
            .width(switchSize)
            .height(switchSize / 2)
            .clip(shape = CircleShape)
            .clickable { onClick() }
    ) {
        AnimatedVisibility(
            visible = isDarkTheme,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            NightSkyBackground(
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        AnimatedVisibility(
            visible = !isDarkTheme,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color(0xFF04B4EC)
                    )
            )
        }


        Box(
            modifier = Modifier
                .size(switchSize / 2)
                .offset(x = offset)
                .padding(padding)
                .clip(shape = CircleShape)
                .shadow(
                    elevation = switchSize,
                    shape = CircleShape,
                    spotColor = Color(0xFFFC9601),
                    ambientColor = Color(0xFFFC9601)
                )
                .background(
                    Brush.linearGradient(
                        colors = if (isDarkTheme) {
                            listOf(
                                Color(0xFFE8E8E8),
                                Color(0xFFE8E8E8)
                            )
                        } else {
                            listOf(
                                Color(0xEFFFCC33),
                                Color(0xEFFC9601)
                            )
                        },
                        start = Offset(0f, 0f),
                        end = Offset(switchSize.value / 1.5f, switchSize.value / 1.5f)
                    )

                )
        ) {

            AnimatedVisibility(
                visible = isDarkTheme,
                enter = fadeIn(),
                exit = fadeOut() + scaleOut()
            ) {
                Moon(
                    modifier = Modifier
                        .fillMaxSize()
                )
            }



        }

        AnimatedVisibility(
            visible = !isDarkTheme,
            enter = fadeIn() + scaleIn(
                initialScale = 3f,
                animationSpec = tween(durationMillis = 300)
            ),
            exit = fadeOut(),
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterEnd)
                .offset(x = switchSize * 0.1f)
        ) {
            Clouds(
                modifier = Modifier
                    .fillMaxSize()
            )
        }

    }
}

@Preview(showBackground = false)
@Composable
fun ThemeSwitcherPreview() {
    WeatherAppTheme {
        ThemeSwitcher(
            isDarkTheme = false,
            onClick = {}
        )
    }
}