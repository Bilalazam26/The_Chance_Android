package com.thechance.cinematicket.ui.core.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke


@Composable
fun CurvedTopLine(
    modifier: Modifier = Modifier,
    curveHeight: Float = 100f,
    color: Color = Color.Black,
    strokeWidth: Float = 10f
) {

    Canvas(
        modifier = modifier
            .fillMaxSize()
    ) {
        val width = size.width

        val path = Path().apply {
            moveTo(0f, curveHeight)

            quadraticBezierTo(
                width / 2, 0f,
                width, curveHeight
            )
        }

        drawPath(
            path = path,
            color = color,
            style = Stroke(width = strokeWidth)
        )
    }
}

