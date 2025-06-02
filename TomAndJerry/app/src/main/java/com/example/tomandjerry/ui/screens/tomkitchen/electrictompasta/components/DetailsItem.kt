package com.example.tomandjerry.ui.screens.tomkitchen.electrictompasta.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun DetailsItem(
    iconRes: Int,
    title: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD0E5F0)
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = text,
                    tint = Color(0xFF035587)
                )

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0x99121212)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0x5E121212)
                )
            }
        }

    }
}

@Preview
@Composable
fun DetailsItemPreview() {
    TomAndJerryTheme {
        DetailsItem(
            iconRes = R.drawable.ic_temperature,
            title = "1000 V",
            text = "Temperature"
        )
    }
}