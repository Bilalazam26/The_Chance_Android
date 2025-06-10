package com.thechance.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                    AnimatedBoxLayoutSwitcher()

            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedBoxLayoutSwitcher() {
    var isRow by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isRow) 0.9f else 1.1f,
        label = "ScaleAnimation"
    )

    val boxWidthFraction by animateFloatAsState(
        targetValue = if (isRow) 0.5f else 1f,
        label = "WidthFractionAnimation"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { isRow = !isRow },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedContent(
            targetState = isRow,
            transitionSpec = {
                fadeIn() + scaleIn() with fadeOut() + scaleOut()
            },
            label = "LayoutSwitch"
        ) { row ->
            if (row) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AnimatedBox(boxWidthFraction, scale, Color.Red)
                    AnimatedBox(boxWidthFraction, scale, Color.Blue)
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AnimatedBox(boxWidthFraction, scale, Color.Red)
                    AnimatedBox(boxWidthFraction, scale, Color.Blue)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("Tap to switch layout", style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun AnimatedBox(widthFraction: Float, scale: Float, color: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth(widthFraction)
            .aspectRatio(1f)
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .background(color)
    )
}