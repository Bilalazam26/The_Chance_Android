package com.example.tomandjerry.ui.screens.secretepisodes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.model.SecretEpisode
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun MostWatchedItem(
    item: SecretEpisode,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .size(
                width = 212.dp,
                height = 311.dp
            ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.text,
                modifier = Modifier
                    .size(
                        width = 212.dp,
                        height = 311.dp
                    )
                    .clip(RoundedCornerShape(16.dp))
                    .border(
                        width = 1.dp,
                        color = Color(0x261F1F1E),
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0x00000000),
                                Color(0xCC000000),
                            )
                        )
                    )
                    .border(
                        width = 1.dp,
                        color = Color(0x261F1F1E),
                        shape = RoundedCornerShape(16.dp)
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(
                            width = 1.dp,
                            color = Color.White.copy(alpha = .5f),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .background(Color.White.copy(alpha = .24f))
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_cheese),
                        contentDescription = "cheese",
                        tint = Color(0xFFFFAA00)
                    )
                }

                Text(
                    text = item.text,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = FontFamily(
                            Font(R.font.roboto)
                        ),
                        fontWeight = FontWeight.ExtraBold
                    ),
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                )
            }


        }
    }
}

