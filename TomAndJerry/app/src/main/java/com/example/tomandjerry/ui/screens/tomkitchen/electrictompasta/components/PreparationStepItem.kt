package com.example.tomandjerry.ui.screens.tomkitchen.electrictompasta.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun PreparationStepItem(
    stepNumber: Int,
    stepText: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .padding(start = 18.dp),
            shape = RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp),
            colors = CardDefaults.cardColors(
                containerColor = White
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp, horizontal = 26.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = stepText,
                    color = Color(0x99121212),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(unbounded = true),
                    maxLines = 1
                )
            }
        }

        Box(
            modifier = Modifier
                .width(36.dp)
                .height(36.dp)
                .background(White, shape = CircleShape)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = Color(0xFFD0E5F0),
                    shape = CircleShape
                )
                .align(Alignment.CenterStart),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stepNumber.toString(),
                color = Color(0xFF035587),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                maxLines = 1
            )
        }
    }
}

@Preview
@Composable
fun PreparationStepPreview() {
    TomAndJerryTheme {
        PreparationStepItem(
            stepNumber = 1,
            stepText = "Prepare the pasta"
        )
    }
}