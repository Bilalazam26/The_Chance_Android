package com.example.tomandjerry.ui.screens.secretepisodes.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.model.SecretEpisode
import com.example.tomandjerry.ui.screens.secretepisodes.components.MostWatchedItem

@Composable
fun MostWatchedSection(modifier: Modifier = Modifier) {

    val mostWatchedList = listOf(
        SecretEpisode(
            imageRes = R.drawable.episode_1_image,
            text = "Number 404 - The Cursed Cheese \uD83E\uDDC0"
        ),
        SecretEpisode(
            imageRes = R.drawable.episode_2_image,
            text = "Chase on the moon \uD83C\uDF15\n"
        )
    )
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Most watched",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = FontFamily(
                        Font(R.font.roboto)
                    ),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black
                ),
                color = Color(0xDE1F1F1E)
            )

            Text(
                text = "View all →",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color(0xFF035486)
            )
        }

        LazyRow(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(mostWatchedList) {
                MostWatchedItem(
                    item = it
                )
            }
        }
    }
}