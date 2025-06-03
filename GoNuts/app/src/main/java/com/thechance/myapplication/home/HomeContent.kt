package com.thechance.myapplication.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.myapplication.Donut
import com.thechance.myapplication.R
import com.thechance.myapplication.home.components.DonutItem
import com.thechance.myapplication.home.components.DonutOfferItem
import com.thechance.myapplication.ui.theme.GoNutsTheme

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Start
    ) {
        Text(
            text = "Today Offers",
            style = MaterialTheme.typography.titleMedium,
            color = Black,
            modifier = Modifier
                .padding(start = 40.dp)
        )
        val offers = listOf(
            Donut(
                "Strawberry Wheel",
                "These Baked Strawberry Donuts are filled with fresh strawberries...",
                20,
                16,
                R.drawable.donut_offer_1_image
            ), Donut(
                "Chocolate Glaze",
                "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                20,
                16,
                R.drawable.donut_offer_2_image,
                Color(0xFFFFC7D0)
            )
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(38.dp)
        ) {
            items(offers) {
                DonutOfferItem(
                    donut = it,
                    onClick = onClick
                )
            }

        }

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Text(
            text = "Donuts",
            style = MaterialTheme.typography.titleMedium,
            color = Black,
            modifier = Modifier
                .padding(start = 40.dp)
        )


        val donuts = listOf(
            Donut(
                name = "Chocolate Cherry",
                price = 22,
                imageRes = R.drawable.donut_1_image
            ),Donut(
                name = "Strawberry Rain",
                price = 22,
                imageRes = R.drawable.donut_2_image
            ),Donut(
                name = "Strawberry Wheal",
                price = 22,
                imageRes = R.drawable.donut_3_image
            ),
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp),
            contentPadding = PaddingValues(start = 24.dp, bottom = 36.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(donuts) {
                DonutItem(
                    donut = it
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeContentPreview() {
    GoNutsTheme {
        HomeContent()
    }
}