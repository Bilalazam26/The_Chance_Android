package com.example.tomandjerry.ui.screens.tomaccount.setions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tomandjerry.R

@Composable
fun TomAccountHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.tom_profile_image),
            contentDescription = "Tom Account",
            modifier = Modifier
                .size(64.dp)
                .clip(
                    shape = RoundedCornerShape(12.dp)
                ),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "Tom",
            style = MaterialTheme.typography.bodyLarge,
            color = White
        )

        Text(
            text = "specializes in failure!",
            style = MaterialTheme.typography.bodySmall,
            color = White.copy(alpha = .8f)
        )

        Box(
            modifier = Modifier
                .size(97.dp, 25.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(White.copy(alpha = .12f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Edit foolishness",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 10.sp
                ),
                color = White
            )
        }

    }

}