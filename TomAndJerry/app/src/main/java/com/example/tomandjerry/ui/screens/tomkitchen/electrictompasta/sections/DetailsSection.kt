package com.example.tomandjerry.ui.screens.tomkitchen.electrictompasta.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.screens.tomkitchen.electrictompasta.components.DetailsItem
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun DetailsSection(modifier: Modifier = Modifier) {

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val totalHorizontalPadding = 8.dp * 2 + 16.dp * 2
    val componentWidth = (screenWidthDp.dp - totalHorizontalPadding) / 3

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Details",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xDE1F1F1E)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DetailsItem(
                iconRes = R.drawable.ic_temperature,
                title = "1000 V",
                text = "Temperature",
                modifier = Modifier
                    .weight(1f)
            )

            DetailsItem(
                iconRes = R.drawable.ic_timer,
                title = "3 sparks",
                text = "Time",
                modifier = Modifier
                    .weight(1f)
            )

            DetailsItem(
                iconRes = R.drawable.ic_evil,
                title = "1M 12k",
                text = "N0. of deaths",
                modifier = Modifier
                    .weight(1f)
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailsSectionPreview() {
    TomAndJerryTheme {
        DetailsSection()
    }
}