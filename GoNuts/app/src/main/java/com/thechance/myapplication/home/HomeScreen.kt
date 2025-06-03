package com.thechance.myapplication.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.myapplication.ui.theme.GoNutsTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            HomeAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 40.dp,
                        vertical = 54.dp
                    )
                    .clickable {onBackClick()},
            )
        },
        bottomBar = {
            HomeBottomBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 40.dp
                    )
                    .padding(
                        bottom = 36.dp
                    )
            )
        },
        containerColor = White
    ) {
        HomeContent(
            modifier = modifier
                .padding(it),
            onClick = onClick
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    GoNutsTheme {
        HomeScreen()
    }
}