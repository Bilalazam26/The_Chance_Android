package com.thechance.pizzaoven.ui.pizzascreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun IngredientsOnPizza(
    ingredients: List<Int>,
    size: Dp,
    modifier: Modifier = Modifier
) {
    val radius = with(LocalDensity.current) { size.toPx() / 2 - 32 }

    val allPositions = remember { generateCircularPositions() }

    val ingredientToPositions = remember { mutableStateMapOf<Int, List<Offset>>() }
    val usedPositions = remember { mutableStateOf(setOf<Offset>()) }

    assignIngredientPositions(
        ingredients = ingredients,
        allPositions = allPositions,
        previousAssignments = ingredientToPositions,
        usedPositions = usedPositions.value.toMutableSet(),
        countPerIngredient = 15
    )

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        ingredientToPositions.forEach { (ingredientId, positions) ->
            positions.take(4).forEach { offset ->
                Image(
                    painter = painterResource(id = ingredientId),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(36.dp)
                        .graphicsLayer {
                            translationX = offset.x * radius
                            translationY = offset.y * radius
                        }
                )
            }
        }
    }
}

fun generateCircularPositions(
    layers: Int = 8,
    pointsPerLayer: Int = 30
): List<Offset> {
    return buildList {
        for (r in 1..layers) {
            val distance = r.toFloat() / layers
            for (i in 0 until pointsPerLayer) {
                val angle = (2 * Math.PI / pointsPerLayer) * i
                add(
                    Offset(
                        (cos(angle) * distance).toFloat(),
                        (sin(angle) * distance).toFloat()
                    )
                )
            }
        }
    }
}

fun assignIngredientPositions(
    ingredients: List<Int>,
    allPositions: List<Offset>,
    previousAssignments: MutableMap<Int, List<Offset>>,
    usedPositions: MutableSet<Offset>,
    countPerIngredient: Int
): Map<Int, List<Offset>> {
    for (ingredientId in ingredients) {
        if (ingredientId !in previousAssignments) {
            val available = allPositions - usedPositions
            val assigned = available.shuffled().take(countPerIngredient)
            previousAssignments[ingredientId] = assigned
            usedPositions.addAll(assigned)
        }
    }
    return previousAssignments
}