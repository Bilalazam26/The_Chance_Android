package com.example.tomandjerry.ui.screens.secretepisodes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.R

@Composable
fun SecretEpisodesTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image_secret),
            contentDescription = "Profile",
            modifier = Modifier
                .size(40.dp)
                .border(
                    width = 0.5.dp,
                    color = Color(0x261F1F1E),
                    shape = RoundedCornerShape(12.dp)
                )
                .clip(
                    shape = RoundedCornerShape(12.dp)
                ),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(id = R.drawable.ic_search_secret),
            contentDescription = "Search",
            modifier = Modifier
                .size(40.dp)
                .border(
                    width = 0.5.dp,
                    color = Color(0x261F1F1E),
                    shape = RoundedCornerShape(12.dp)
                )
                .clip(
                    shape = RoundedCornerShape(12.dp)
                )
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF0085E3),
                            Color(0xFF00497D),
                        )
                    )
                )
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )

    }

}

