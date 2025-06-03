package com.example.tomandjerry.ui.core


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IconTextRow(
    iconRes: Int,
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    textColor: Color = White.copy(alpha = .87f),
    iconContainerColor: Color = Transparent,
    iconTint: Color = White,
    iconContainerSize: Dp = 24.dp,
    iconWidth: Dp = 32.dp,
    iconHeight: Dp = 32.dp
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(iconContainerSize)
                .clip(
                    shape = RoundedCornerShape(8.dp)
                )
                .background(
                    color = iconContainerColor
                ),
            contentAlignment = Alignment.Center

        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = "Tom Icon",
                tint = iconTint,
                modifier = Modifier
                    .size(iconWidth, iconHeight)
            )
        }

        Text(
            text = text,
            style = textStyle,
            color = textColor
        )
    }
}