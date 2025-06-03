package com.example.tomandjerry.ui.screens.secretepisodes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.ui.screens.secretepisodes.sections.MostWatchedSection
import com.example.tomandjerry.ui.screens.secretepisodes.sections.PopularCharacterSection
import com.example.tomandjerry.ui.screens.secretepisodes.sections.SecretEpisodesHeader
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun SecretEpisodesScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFEEF4F6))
            .padding(bottom = 16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFA3DCFF),
                                Color(0xFFEEF4F6),
                            )
                        )
                    )
                    .padding(top = 16.dp, start = 16.dp, bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SecretEpisodesHeader()
                MostWatchedSection()
            }
            PopularCharacterSection()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SecretEpisodesScreenPreview() {
    TomAndJerryTheme {
        SecretEpisodesScreen()
    }
}