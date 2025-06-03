package com.example.tomandjerry.ui.screens.jerrystore

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.ui.screens.jerrystore.components.appbar.JerryStoreAppBar
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun JerryStoreScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        containerColor = Color(0xFFEEF4F6),
        topBar = {

            JerryStoreAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 16.dp)
            )
        }
    ) { paddingValues ->
        JerryStoreScreenContent(
            modifier = Modifier.padding(paddingValues)
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