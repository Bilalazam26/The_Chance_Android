package com.thechance.weatherapp.weather.ui.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.thechance.weatherapp.R
import com.thechance.weatherapp.core.ui.theme.DarkPurpleBlur

@Composable
fun ScreenHeaderSection(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .shadow(
                    elevation = 120.dp,
                    spotColor = DarkPurpleBlur,
                    ambientColor = DarkPurpleBlur,
                    shape = CircleShape
                )

        )
        Image(
            painter = painterResource(id = R.drawable.mainly_clear),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .aspectRatio(1.35f)
        )
    }


}