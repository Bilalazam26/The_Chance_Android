package com.example.tomandjerry.ui.screens.tomkitchen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun TomKitchenScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        TomKitchenScreenBackground()
        TomKitchenScreenContent()
    }
}



@Preview(showBackground = true)
@Composable
fun TomKitchenScreenPreview() {
    TomAndJerryTheme {
        TomKitchenScreen()
    }
}