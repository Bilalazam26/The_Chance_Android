package com.example.tomandjerry.ui.screens.jerrystore

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun JerryStoreScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        containerColor = Color(0xFFEEF4F6)
    ) { paddingValues ->
        paddingValues
        JerryStoreScreenContent(
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JerryStoreScreenPreview() {
    TomAndJerryTheme {
        JerryStoreScreen()
    }
}