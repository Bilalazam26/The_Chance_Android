package com.thechance.cinematicket.ui.core.components

import androidx.compose.foundation.shape.GenericShape
import androidx.compose.ui.graphics.Shape


fun TopBottomCurvedShape(
    curveHeight: Float = 100f
): Shape = GenericShape { size, _ ->
    val topWidth = size.width
    val bottomWidth = size.width * .8f
    val height = size.height

    moveTo(0f, curveHeight)

    // Top curve
    quadraticBezierTo(
        topWidth / 2, 0f,
        topWidth, curveHeight
    )

    // Right edge
    lineTo(bottomWidth, height)

    // Bottom curve
    quadraticBezierTo(
        topWidth / 2, height - curveHeight,
        topWidth - bottomWidth, height
    )

    // Left edge
    close()
}
