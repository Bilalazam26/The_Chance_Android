package com.example.tomandjerry.ui.screens.jerrystore.components.promotionbanner

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PromotionBannerBackground(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
    ) {
        val canvasWidth = size.width

        val oval1Size = Size(140.dp.toPx(), 140.dp.toPx())
        val oval1Offset = Offset(
            x = canvasWidth - 118.dp.toPx(),
            y = (-10).dp.toPx()
        )
        rotate(
            degrees = 26f,
            pivot = Offset(oval1Offset.x + oval1Size.width / 2, oval1Offset.y + oval1Size.height)) {
            drawOval(
                color = Color.White.copy(alpha = 0.04f),
                topLeft = oval1Offset,
                size = oval1Size
            )
        }


        val oval2Size = Size(140.dp.toPx(), 140.dp.toPx())
        val oval2Offset = Offset(
            x = canvasWidth - 118.dp.toPx(),
            y = (-10).dp.toPx()
        )
        rotate(
            degrees = 20f,
            pivot = Offset(oval2Offset.x + oval2Size.width / 2, oval2Offset.y + oval2Size.height)) {
            drawOval(
                color = Color.White.copy(alpha = 0.04f),
                topLeft = oval2Offset,
                size = oval2Size
            )
        }

        /*val oval2Size = Size(140.dp.toPx(), 140.dp.toPx())
        val oval2Offset = Offset(
            x = canvasWidth - 116.dp.toPx(),
            y = (-11).dp.toPx()
        )
        rotate(
            degrees = 19f,
            pivot = Offset(oval2Offset.x + oval2Size.width / 2, oval2Offset.y + oval2Size.height)) {
            drawOval(
                color = Color.White.copy(alpha = 0.04f),
                topLeft = oval2Offset,
                size = oval2Size
            )
        }*/

       /* val oval2Size = Size(180.dp.toPx(), 220.dp.toPx())
        val oval2Offset = Offset(
            x = canvasWidth - 100.dp.toPx(),
            y = -6.dp.toPx()
        )
        drawOval(
            color = Color.White.copy(alpha = 0.04f),
            topLeft = oval2Offset,
            size = oval2Size
        )*/
    }
}

@Preview()
@Composable
fun PromotionBannerBackgroundPreview() {
    PromotionBannerBackground()
}