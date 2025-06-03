package com.example.tomandjerry.ui.screens.tomkitchen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddToCartButton(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        border = BorderStroke(
            width = 1.dp,
            color = Color(0xFF1F1F1E).copy(alpha = 0.12f)
        ),
        color = White
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF226993)),
            contentAlignment = Center
        ) {
            Row(
                modifier = Modifier.padding(12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = CenterVertically
            ) {
                Text(
                    text = "Add to cart",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 16.sp
                    ),
                    color = White.copy(alpha = 0.87f)
                )

                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(White.copy(alpha = .38f))
                )

                Column(
                    horizontalAlignment = CenterHorizontally
                ) {
                    Text(
                        text = "3 cheeses",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            lineHeight = 16.sp
                        ),
                        color = White
                    )
                    Text(
                        text = "5 cheeses",
                        style = MaterialTheme.typography.bodySmall.copy(
                            lineHeight = 16.sp
                        ),
                        color = White.copy(alpha = 0.8f),
                        textDecoration = TextDecoration.LineThrough
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AddToCartButtonPreview() {
    AddToCartButton()
}