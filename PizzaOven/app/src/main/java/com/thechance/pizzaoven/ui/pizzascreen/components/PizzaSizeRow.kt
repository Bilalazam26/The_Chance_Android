package com.thechance.pizzaoven.ui.pizzascreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PizzaSizeRow(
    modifier: Modifier = Modifier,
    changePizzaSize: (Int) -> Unit
) {
    var sizes = listOf("S", "M", "L")
    var selectedSize by remember {
        mutableIntStateOf(0)
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = CenterVertically
    ) {
        sizes.forEachIndexed { index, size ->
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .then(
                        if (index == selectedSize) {
                            Modifier
                                .shadow(10.dp, CircleShape, clip = false)
                                .clip(CircleShape)
                                .background(Color.White, CircleShape)
                        } else Modifier
                    )
                    .clip(CircleShape) // To ensure ripple is circular
                    .clickable {
                        selectedSize = index
                        changePizzaSize(index)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = size,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}