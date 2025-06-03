package com.example.tomandjerry.ui.screens.tomkitchen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun TomKitchenScreenBackground(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0x80035484)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            Image(
                painter = painterResource(id = R.drawable.ellipse_bg),
                contentDescription = "Tom Kitchen Background",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(width = screenWidth.div(1.8f), height = screenHeight.div(2.2f))
                    .graphicsLayer {
                        translationY = -42.dp.toPx()
                        clip = true
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TomKitchenScreenBackgroundPreview() {
    TomAndJerryTheme {
        TomKitchenScreenBackground()
    }
}