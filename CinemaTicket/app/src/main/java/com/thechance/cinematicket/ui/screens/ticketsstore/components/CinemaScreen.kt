package com.thechance.cinematicket.ui.screens.ticketsstore.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.cinematicket.R
import com.thechance.cinematicket.ui.core.components.CurvedTopLine
import com.thechance.cinematicket.ui.core.components.TopBottomCurvedShape

@Composable
fun CinemaScreen(modifier: Modifier = Modifier) {
    val lineCurveHeight = with(LocalDensity.current) { 28.dp.toPx() }
    val pictureCurveHeight = with(LocalDensity.current) { 24.dp.toPx() }

    Image(
        painter = painterResource(id = R.drawable.movie_1_wide_poster),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 50.dp, horizontal = 36.dp)
            .height(100.dp)
            .clip(TopBottomCurvedShape(pictureCurveHeight))

    )

    CurvedTopLine(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
            .padding(horizontal = 12.dp),
        curveHeight = lineCurveHeight
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CinemaScreenPreview() {
    CinemaScreen()
}