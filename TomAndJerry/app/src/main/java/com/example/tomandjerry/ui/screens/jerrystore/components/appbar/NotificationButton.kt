package com.example.tomandjerry.ui.screens.jerrystore.components.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun NotificationButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(width = 41.dp, height = 44.5.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(
                    shape = RoundedCornerShape(12.dp)
                )
                .border(
                    width = 0.5.dp,
                    color = Color(0x1F1F1E26),
                    shape = RoundedCornerShape(12.dp)
                )
                .align(Alignment.BottomCenter)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.notification),
                contentDescription = "Notification",
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(14.dp)
                .background(Color(0xFF03578A))
                .align(Alignment.TopEnd),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "3",
                style = MaterialTheme.typography.labelMedium,
                color = Color.White,
                modifier = Modifier
                    .fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }

    }



}

@Preview(showBackground = true)
@Composable
fun NotificationButtonPreview() {
    TomAndJerryTheme {
        NotificationButton()
    }
}