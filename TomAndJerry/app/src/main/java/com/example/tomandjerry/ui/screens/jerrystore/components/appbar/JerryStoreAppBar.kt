package com.example.tomandjerry.ui.screens.jerrystore.components.appbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun JerryStoreAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppBarInfo()
        NotificationButton()
    }
}

@Preview(showBackground = true)
@Composable
fun JerryStoreAppBarPreview() {
    TomAndJerryTheme {
        JerryStoreAppBar()
    }
}