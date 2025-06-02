package com.example.tomandjerry.ui.screens.secretepisodes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.model.Character

@Composable
fun PopularCharacterItem(
    item: Character,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(
                width = 140.dp,
                height = 128.dp
            )
    ) {
        Box(
            modifier = Modifier
                .size(
                    width = 140.dp,
                    height = 104.dp
                )
                .clip(RoundedCornerShape(16.dp))
                .background(item.containerColor)
                .align(Alignment.BottomCenter)
        )

        Column(
            modifier = Modifier
                .height(116.dp)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.name,
                modifier = Modifier
                    .height(64.dp),
                contentScale = ContentScale.FillHeight
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = item.name,
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xDE1F1F1E),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = item.description,
                style = MaterialTheme.typography.bodySmall,
                color = Color(0x991F1F1E),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }

    }


}

@Preview(showBackground = true)
@Composable
fun PreviewPopularCharacterItem() {
    PopularCharacterItem(
        item = Character(
            imageRes = R.drawable.character_jerry_kid_image,
            name = "Jerry",
            description = "Hungry mouse",
            containerColor = Color(0xFFC5E7FC)
        )
    )
}