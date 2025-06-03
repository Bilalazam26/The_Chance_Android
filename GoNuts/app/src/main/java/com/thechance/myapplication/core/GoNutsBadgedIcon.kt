package com.thechance.myapplication.core

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thechance.myapplication.R
import com.thechance.myapplication.ui.theme.GoNutsTheme

@Composable
fun GoNutsBadgedIcon(
    badgeText: String,
    icon: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
    ) {
        IconButton(
            modifier = Modifier
                .align(Alignment.Center),
            onClick = {}
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = icon),
                contentDescription = "Cart",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 1.dp, end = 9.dp)
                .size(9.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .border(1.dp, White, CircleShape)
                .align(Alignment.TopEnd),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = badgeText,
                modifier = Modifier
                    .align(Alignment.Center),
                style = TextStyle(
                    fontSize = 5.sp,
                    fontFamily = FontFamily(
                        Font(R.font.roboto)
                    ),
                    textAlign = TextAlign.Center
                ),
                color = White
            )
        }
    }
}

@Preview
@Composable
fun GoNutsBadgedIconPreview() {
    GoNutsTheme {
        GoNutsBadgedIcon(
            badgeText = "2",
            icon = R.drawable.ic_cart,
            modifier = Modifier
                .size(35.dp)
        )
    }
}