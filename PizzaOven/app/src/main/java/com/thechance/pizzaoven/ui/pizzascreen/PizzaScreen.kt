package com.thechance.pizzaoven.ui.pizzascreen


import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thechance.pizzaoven.R
import com.thechance.pizzaoven.ui.pizzascreen.components.IngredientsOnPizza
import com.thechance.pizzaoven.ui.pizzascreen.components.PizzaFab
import com.thechance.pizzaoven.ui.pizzascreen.components.PizzaIngredientsRow
import com.thechance.pizzaoven.ui.pizzascreen.components.PizzaSizeRow
import com.thechance.pizzaoven.ui.pizzascreen.components.PizzaTopBar
import com.thechance.pizzaoven.ui.theme.PizzaOvenTheme

@Composable
fun PizzaScreen(modifier: Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val plateSize = screenWidth - (2 * 48).dp
    val breadImages = listOf(
        R.drawable.bread_1,
        R.drawable.bread_2,
        R.drawable.bread_3,
        R.drawable.bread_4,
        R.drawable.bread_5
    )

    val ingredientIcons = mapOf<Int, List<Int>>(
        0 to listOf(
            R.drawable.basil_3,
            R.drawable.basil_1,
            R.drawable.basil_2,
            R.drawable.basil_4,
            R.drawable.basil_5
        ),
        1 to listOf(
            R.drawable.onion_3,
            R.drawable.onion_1,
            R.drawable.onion_2,
            R.drawable.onion_4,
            R.drawable.onion_5
        ),
        2 to listOf(
            R.drawable.broccoli_3,
            R.drawable.broccoli_1,
            R.drawable.broccoli_2,
            R.drawable.broccoli_4,
            R.drawable.broccoli_5
        ),
        3 to listOf(
            R.drawable.mushroom_3,
            R.drawable.mushroom_1,
            R.drawable.mushroom_2,
            R.drawable.mushroom_4,
            R.drawable.mushroom_5
        ),
        4 to listOf(
            R.drawable.sausage_9,
            R.drawable.sausage_1,
            R.drawable.sausage_2,
            R.drawable.sausage_4,
            R.drawable.sausage_5
        ),
    )

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { breadImages.size }
    )

    var pizzaSize by remember { mutableIntStateOf(0) }
    var selectedIngredients by remember { mutableStateOf(setOf<Int>()) }

    val animatedSize by animateDpAsState(
        targetValue = when (pizzaSize) {
            0 -> plateSize - 78.dp
            1 -> plateSize - 64.dp
            else -> plateSize - 42.dp
        },
        animationSpec = tween(durationMillis = 500)
    )

    Scaffold(
        topBar = {
            PizzaTopBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        },
        floatingActionButton = { PizzaFab() },
        floatingActionButtonPosition = FabPosition.Center,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(screenWidth)
                    .padding(top = 16.dp),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.plate),
                    contentDescription = "Plate",
                    modifier = Modifier
                        .size(plateSize)
                )

                Box(
                    modifier = Modifier
                        .size(screenWidth),
                    contentAlignment = Alignment.Center
                ) {
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier
                            .fillMaxSize()
                    ) { page ->

                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = breadImages[page]),
                                contentDescription = "Pizza Bread",
                                modifier = Modifier
                                    .size(animatedSize)
                            )
                            ingredientIcons.forEach { entry ->
                                androidx.compose.animation.AnimatedVisibility(
                                    visible = selectedIngredients.contains(entry.key),
                                    enter = fadeIn() + scaleIn(
                                        initialScale = 3f,
                                        animationSpec = tween(durationMillis = 300)
                                    ),
                                    exit = fadeOut(),
                                    modifier = Modifier
                                ) {
                                    IngredientsOnPizza(
                                        ingredients = entry.value,
                                        size = animatedSize,
                                        modifier = Modifier
                                            .size(animatedSize)
                                    )
                                }

                            }
                        }
                    }
                }
            }

            Text(
                text = "$17",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            PizzaSizeRow { pizzaSize = it }

            Text(
                text = "Customize Your Pizza",
                color = Color.LightGray,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 16.dp)
            )

            PizzaIngredientsRow(
                selectedIngredients = selectedIngredients,
                onIngredientToggle = { index ->
                    selectedIngredients = selectedIngredients.toMutableSet().apply {
                        if (contains(index)) remove(index) else add(index)
                    }
                },
                ingredientIcons = ingredientIcons.map { it.value[0] }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PizzaScreenPreview() {
    PizzaOvenTheme {
        PizzaScreen()
    }
}
