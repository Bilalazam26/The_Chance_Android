package com.example.tomandjerry.ui.screens.tomaccount.components.headerbackground

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tomandjerry.ui.theme.TomAndJerryTheme
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.dp

//top-start -> 0, 0
//top-end -> width, 0
//bottom-start -> 0, height
//bottom-end -> width, height

@Composable
fun HeaderBackground(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.size(362.dp, 242.dp)) {
        val width = size.width
        val height = size.height

        val backgroundColor = Color(0xFF226993)

        val gradientBrush1 = Brush.linearGradient(
            colors = listOf(
                White.copy(alpha = 0.41f),
                Transparent
            ),
            start = Offset(width * 1.2f, height * 1.5f),
            end = Offset(width * .3f, 0f)
        )
        val gradientBrush2 = Brush.linearGradient(
            colors = listOf(
                White.copy(alpha = 0.41f),
                Transparent
            ),
            start = Offset(width * .63f, height * 3.2f),
            end = Offset(0f, 0f)
        )

        val path1 = Path().apply {
            moveTo(0f, 0f)
            lineTo(width, 0f)
            lineTo(width, height * .3553f)
            lineTo(0f, height * .7892f)
            close()
        }
        val path2 = Path().apply {
            moveTo(width, 0f)
            lineTo(width, height)
            lineTo(width * .8055f, height)
            lineTo(0f, height * .2314f)
            lineTo(0f, 0f)
            close()
        }


        drawRect(color = backgroundColor)
        drawPath(
            path = path1,
            brush = gradientBrush1,
            style = Fill
        )
        drawPath(
            path = path2,
            brush = gradientBrush2,
            style = Fill
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGeometricBackground() {
    TomAndJerryTheme {
        HeaderBackground()
    }
}