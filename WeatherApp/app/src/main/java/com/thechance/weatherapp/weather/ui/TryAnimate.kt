package com.thechance.weatherapp.weather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.weatherapp.R
import com.thechance.weatherapp.weather.ui.components.MinMaxTempContainer

@Composable
fun TryAnimate(modifier: Modifier = Modifier) {

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp
    val imageWidth = screenWidthDp - 128.dp
    val imageHeight = (imageWidth / 1.35f)
    Box(
        modifier = modifier
            .background(Color.Black)
            .fillMaxWidth()
            .height(imageHeight + 143.dp)
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
                .padding(bottom = 12.dp)
                .align(Alignment.BottomCenter),
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
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TryAnimatePreview() {
    TryAnimate()
}