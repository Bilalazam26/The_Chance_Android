package com.thechance.pizzaoven.ui.pizzascreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PizzaIngredientsRow(
    modifier: Modifier = Modifier,
    selectedIngredients: Set<Int>,
    onIngredientToggle: (Int) -> Unit,
    ingredientIcons: List<Int>
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        itemsIndexed(ingredientIcons) { index, ingredientRes ->
            val isSelected = selectedIngredients.contains(index)

            Box(
                modifier = Modifier
                    .size(64.dp)
                    .then(
                        if (isSelected) {
                            Modifier
                                .background(
                                    color = Color.Cyan.copy(alpha = 0.1f),
                                    shape = CircleShape
                                )
                        } else {
                            Modifier
                        }
                    )
                    .clip(CircleShape)
                    .clickable { onIngredientToggle(index) }
                    .padding(12.dp),
                contentAlignment = Alignment.Center

            ) {
                Image(
                    painter = painterResource(id = ingredientRes),
                    contentDescription = "Ingredient $index"
                )
            }
        }
    }
}