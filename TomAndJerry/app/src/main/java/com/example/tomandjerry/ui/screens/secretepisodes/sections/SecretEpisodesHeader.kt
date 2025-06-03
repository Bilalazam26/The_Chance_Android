package com.example.tomandjerry.ui.screens.secretepisodes.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.screens.secretepisodes.components.SecretEpisodesTopBar

@Composable
fun SecretEpisodesHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SecretEpisodesTopBar()

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Deleted episodes of Tom and Jerry!",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontFamily = FontFamily(
                            Font(R.font.roboto)
                        ),
                        fontWeight = FontWeight.Black
                    ),
                    color = Color(0xDE1F1F1E),
                    maxLines = 2
                )

                Text(
                    text = "Scenes that were canceled for... mysterious (and sometimes embarrassing) reasons.",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = FontFamily(
                            Font(R.font.roboto)
                        )
                    ),
                    color = Color(0x991F1F1E),
                    maxLines = 3
                )
            }


            Image(
                painter = painterResource(id = R.drawable.tom_and_jerry),
                contentDescription = "Filter",
                modifier = Modifier
                    .size(
                        width = 112.dp,
                        height = 178.dp
                    )
            )
        }
    }

}

@Preview
@Composable
fun SecretEpisodesHeaderPreview() {
    SecretEpisodesHeader()
}