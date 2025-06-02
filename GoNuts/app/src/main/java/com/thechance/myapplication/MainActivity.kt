package com.thechance.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.thechance.myapplication.details.DonutDetailsScreen
import com.thechance.myapplication.getstarted.GetStartedScreen
import com.thechance.myapplication.home.HomeScreen
import com.thechance.myapplication.ui.theme.GoNutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoNutsTheme {
                var screen by remember { mutableIntStateOf(0) }
                when (screen) {
                    0 -> GetStartedScreen(
                        onStartClick = {
                            screen = 1
                        }
                    )
                    1 -> HomeScreen(
                        onClick = {
                            screen = 2
                        }
                    ) {
                        screen = 0
                    }

                    2 -> DonutDetailsScreen(
                        donut = Donut(
                            "Strawberry Wheel",
                            "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                            16,
                            16,
                            R.drawable.donut_offer_1_image
                        ),
                        onBackClick = {
                            screen = 1
                        }
                    )
                }
            }
        }
    }
}