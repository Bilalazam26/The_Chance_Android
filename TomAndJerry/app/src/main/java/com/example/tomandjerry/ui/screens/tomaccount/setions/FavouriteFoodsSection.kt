package com.example.tomandjerry.ui.screens.tomaccount.setions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.core.IconTextRow

@Composable
fun FavouriteFoodsSection(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "His favourite foods",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xDE1F1F1E)
        )

        IconTextRow(
            iconRes = R.drawable.ic_alert,
            text = "Mouses",
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 16.sp
            ),
            textColor = Color(0xDE1F1F1E),
            iconContainerColor = White,
            iconTint = Color(0xFF1F1F1E),
            iconContainerSize = 40.dp,
            iconWidth = 21.5.dp,
            iconHeight = 20.5.dp
        )


        IconTextRow(
            iconRes = R.drawable.ic_hamburger,
            text = "Last stolen meal",
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 16.sp
            ),
            textColor = Color(0xDE1F1F1E),
            iconContainerColor = White,
            iconTint = Color(0xFF1F1F1E),
            iconContainerSize = 40.dp,
            iconWidth = 21.5.dp,
            iconHeight = 17.5.dp
        )

        IconTextRow(
            iconRes = R.drawable.ic_sleeping,
            text = "Change sleep mood",
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 16.sp
            ),
            textColor = Color(0xDE1F1F1E),
            iconContainerColor = White,
            iconTint = Color(0xFF1F1F1E),
            iconContainerSize = 40.dp,
            iconWidth = 21.5.dp,
            iconHeight = 21.5.dp
        )
    }
}