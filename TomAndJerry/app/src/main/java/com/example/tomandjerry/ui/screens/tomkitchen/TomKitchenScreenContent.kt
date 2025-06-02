package com.example.tomandjerry.ui.screens.tomkitchen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.core.IconTextRow
import com.example.tomandjerry.ui.screens.tomkitchen.components.AddToCartButton
import com.example.tomandjerry.ui.screens.tomkitchen.electrictompasta.ElectricTomPasta
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun TomKitchenScreenContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 18.dp)
    ) {
        Column(
            modifier = Modifier
                .align(BottomCenter)
        ) {
            ElectricTomPasta(
                modifier = Modifier
                    .weight(1f)
            )
            AddToCartButton(
                modifier = Modifier
                    .fillMaxWidth()
            )
        }


        Image(
            painter = painterResource(id = R.drawable.pasta),
            contentDescription = "Tom Kitchen Pasta",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth(.55f)
                .aspectRatio(1.11f)
                .padding(end = 24.dp)
                .align(TopEnd)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 22.dp,
                    start = 18.dp
                ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            IconTextRow(
                iconRes = R.drawable.ic_ruler,
                text = "High Tension",
            )

            IconTextRow(
                iconRes = R.drawable.ic_chef,
                text = "Shocking foods"
            )
        }



    }

}


@Preview(showBackground = true)
@Composable
fun TomKitchenScreenContentPreview() {
    TomAndJerryTheme {
        TomKitchenScreenContent()
    }
}