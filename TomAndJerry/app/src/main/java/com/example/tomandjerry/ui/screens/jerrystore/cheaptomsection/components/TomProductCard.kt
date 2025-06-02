package com.example.tomandjerry.ui.screens.jerrystore.cheaptomsection.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.tomandjerry.ui.model.TomProduct
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.core.PriceContainer
import com.example.tomandjerry.ui.theme.TomAndJerryTheme


@Composable
fun TomProductCard(
    tomProduct: TomProduct,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(235.dp)
    ) {

        Box(
            modifier = Modifier
                .height(219.dp)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(bottom = 8.dp)
                        .align(Alignment.TopCenter),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = tomProduct.name,
                        modifier = Modifier
                            .height(27.dp),
                        color = Color(0xFF1F1F1E),
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = tomProduct.description,
                        modifier = Modifier
                            .height(54.dp),
                        color = Color(0xFF969799),
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier
                            .wrapContentHeight(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        PriceContainer(
                            price = tomProduct.price,
                            isDiscount = tomProduct.isDiscount,
                            oldPrice = tomProduct.oldPrice,
                            modifier = Modifier
                                .weight(1f)
                        )

                        Card(
                            modifier = Modifier
                                .size(30.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                            border = BorderStroke(
                                width = 1.dp,
                                color = Color(0xFF03578A)
                            )
                        ) {
                            Box(modifier = Modifier.fillMaxSize()) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_cart),
                                    contentDescription = "Cart",
                                    tint = Color(0xFF03578A),
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                )
                            }
                        }
                    }
                }


            }
        }



        Image(
            painter = painterResource(tomProduct.imageRes),
            contentDescription = tomProduct.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .align(Alignment.TopCenter)
        )
    }

}


@Preview(showBackground = true)
@Composable
fun TomProductCardPreview() {
    TomAndJerryTheme {
        TomProductCard(
            TomProduct(
                "Tom the lover",
                "He loves one-sidedly... and is beaten by the other side.",
                R.drawable.tom2,
                5
            )
        )
    }
}