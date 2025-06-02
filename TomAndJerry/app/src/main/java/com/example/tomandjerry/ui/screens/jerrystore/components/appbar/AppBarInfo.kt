package com.example.tomandjerry.ui.screens.jerrystore.components.appbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.R

@Composable
fun AppBarInfo(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .border(
                    width = 0.5.dp,
                    color = Color(0x1F1F1E26),
                    shape = RoundedCornerShape(12.dp)
                )
                .clip(
                    shape = RoundedCornerShape(12.dp)
                )
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Hi, Jerry \uD83D\uDC4B\uD83C\uDFFB",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF1F1F1E)
            )
            Text(
                text = "Which Tom do you want to buy?",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFFA5A6A4)
            )

        }
    }
}