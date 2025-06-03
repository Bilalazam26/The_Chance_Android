package com.thechance.myapplication.getstarted

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.myapplication.R
import com.thechance.myapplication.core.GonutsButton
import com.thechance.myapplication.ui.theme.GoNutsTheme

@Composable
fun GetStartedScreen(
    modifier: Modifier = Modifier,
    onStartClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.donuts),
            contentDescription = "Donuts",
            contentScale = Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.56f)
                .align(TopCenter)
        )

        Column(
            modifier = Modifier
                .align(BottomCenter)
                .padding(horizontal = 40.dp, vertical = 46.dp),
            horizontalAlignment = Start
        ) {
            Text(
                text = "Gonuts\nWith\nDonuts",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            Text(
                text = "Gonuts with Donuts is a Sri Lanka dedicated food outlets for specialize manufacturing of Donuts in Colombo, Sri Lanka.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(
                modifier = Modifier
                    .height(60.dp)
            )

            GonutsButton(
                text = "Get Started",
                onClick = onStartClick
            )
        }
    }

}

@Preview
@Composable
fun GetStartedScreenPreview() {
    GoNutsTheme {
        GetStartedScreen()
    }
}