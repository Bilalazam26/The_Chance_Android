package com.example.tomandjerry.ui.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun PriceContainer(
    price: Int,
    isDiscount: Boolean = false,
    oldPrice: Int = 0,
    modifier: Modifier = Modifier,
    containerColor: Color = Color(0xFFE9F6FB)
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .height(30.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        )
    ) {
        Row(
            modifier = modifier
                .fillMaxHeight()
                .padding(
                    horizontal = 8.dp,
                    vertical = 4.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_price),
                contentDescription = "Discount",
                tint = Color(0xFF03578A),
                modifier = Modifier
            )

            if (isDiscount) {
                Text(
                    text = "$oldPrice",
                    color = Color(0xFF03578A),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.LineThrough
                    )
                )
            }

            Text(
                text = "$price cheeses",
                color = Color(0xFF03578A),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PriceContainerPreview() {
    TomAndJerryTheme {
        PriceContainer(3, true, 5)
    }
}