package com.example.tomandjerry.ui.screens.secretepisodes.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.model.Character
import com.example.tomandjerry.ui.screens.secretepisodes.components.MostWatchedItem
import com.example.tomandjerry.ui.screens.secretepisodes.components.PopularCharacterItem

@Composable
fun PopularCharacterSection(modifier: Modifier = Modifier) {
    val popularCharacters = listOf(
        Character(
            imageRes = R.drawable.character_tom_image,
            name = "Tom",
            description = "Failed stalker",
            containerColor = Color(0xFFFCF2C5)
        ),
        Character(
            imageRes = R.drawable.character_jerry_image,
            name = "Jerry",
            description = "A scammer mouse",
            containerColor = Color(0xFFFCC5E4)
        ),
        Character(
            imageRes = R.drawable.character_jerry_kid_image,
            name = "Jerry",
            description = "Hungry mouse",
            containerColor = Color(0xFFC5E7FC)
        )
    )
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Popular Character",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            color = Color(0xDE1F1F1E),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = FontFamily(
                    Font(R.font.roboto)
                ),
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )
        )
        LazyRow(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        ) {
            items(popularCharacters) {
                PopularCharacterItem(
                    item = it
                )
            }
        }
    }
}