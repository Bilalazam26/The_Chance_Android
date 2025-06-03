package com.thechance.myapplication.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Counter(modifier: Modifier = Modifier) {
    var count by remember { mutableIntStateOf(1) }
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = "-",
            fontSize = 24.sp,
            modifier = Modifier
                .size(45.dp)
                .clickable { if (count > 1) count-- }
                .shadow(8.dp, RoundedCornerShape(16.dp))
                .background(Color.Black, RoundedCornerShape(12.dp))
                .padding(8.dp),
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Text(
            text = count.toString(),
            fontSize = 24.sp,
            modifier = Modifier
                .size(45.dp)
                .shadow(8.dp, RoundedCornerShape(16.dp))
                .background(Color.White, RoundedCornerShape(12.dp))
                .padding(8.dp),
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Text(
            text = "+",
            fontSize = 24.sp,
            modifier = Modifier
                .size(45.dp)
                .clickable { count++ }
                .shadow(8.dp, RoundedCornerShape(16.dp))
                .background(Color.Black, RoundedCornerShape(12.dp))
                .padding(8.dp),
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}