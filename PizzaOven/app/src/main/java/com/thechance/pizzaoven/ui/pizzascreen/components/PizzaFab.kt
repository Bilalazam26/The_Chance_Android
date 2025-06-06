package com.thechance.pizzaoven.ui.pizzascreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PizzaFab(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = { },
        modifier = modifier
            .fillMaxWidth(.5f),
        containerColor = Color(0xFF4B352A),
        contentColor = Color.White
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Add to Cart",
            )

            Text(
                text = "Add to Cart",
            )
        }
    }
}