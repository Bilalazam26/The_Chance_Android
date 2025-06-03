package com.example.tomandjerry.ui.screens.tomaccount

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.ui.screens.tomaccount.components.headerbackground.HeaderBackground
import com.example.tomandjerry.ui.screens.tomaccount.setions.TomAccountHeader
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun TomAccountScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clipToBounds()
    ) {

        HeaderBackground(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .offset(y = (-38).dp)
        )

        //TomAccountBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TomAccountHeader()
            TomAccountScreenContent(
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TomAccountScreenPreview() {
    TomAndJerryTheme {
        TomAccountScreen()
    }
}