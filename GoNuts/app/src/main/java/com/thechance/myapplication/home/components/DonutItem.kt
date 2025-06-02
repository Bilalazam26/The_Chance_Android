package com.thechance.myapplication.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.thechance.myapplication.Donut
import com.thechance.myapplication.R
import com.thechance.myapplication.core.BoxedIcon

@Composable
fun DonutItem(
    donut: Donut,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(138.dp, 167.dp),
    ) {
        Box(
            modifier = Modifier
                .size(138.dp, 111.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    ),
                    clip = false,
                    spotColor = Black.copy(alpha = 0.2f),
                    ambientColor = Black.copy(alpha = 0.3f),
                )
                .background(
                    color = White,
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                )
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
                .align(BottomCenter)
        ) {
            Column(
                modifier = Modifier
                    .width(138.dp)
                    .align(BottomCenter),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Text(
                    text = donut.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Black,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                )

                Text(
                    text = "${donut.price}$",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                    textDecoration = TextDecoration.LineThrough,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                )
            }

        }

        Image(
            painter = painterResource(id = donut.imageRes),
            contentDescription = donut.name,
            contentScale = Crop,
            modifier = Modifier
                .size(104.dp, 112.dp)
                .align(Alignment.TopCenter)
        )
    }
}