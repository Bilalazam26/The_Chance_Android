package com.thechance.cinematicket.ui.screens.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.thechance.cinematicket.R
import com.thechance.cinematicket.ui.screens.movies.components.MoviesScreenBackground
import com.thechance.cinematicket.ui.theme.CinemaTicketTheme

@Composable
fun MoviesScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Color.White
            )
    ) {
        MoviesScreenBackground(
            backgroundImageResource = R.drawable.movie_1_poster_1,
            modifier = Modifier
                .fillMaxHeight(.5f)
                .clipToBounds()
        )

        MoviesScreenContent(
            modifier = Modifier
                .fillMaxSize()
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MoviesScreenPreview() {
    CinemaTicketTheme {
        MoviesScreen()
    }
}