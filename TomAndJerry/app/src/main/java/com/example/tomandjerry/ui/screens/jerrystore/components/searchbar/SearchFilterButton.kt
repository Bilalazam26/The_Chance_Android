package com.example.tomandjerry.ui.screens.jerrystore.components.searchbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.R

@Composable
fun SearchFilterButton(modifier: Modifier = Modifier) {
    IconButton(
        onClick = { },
        modifier = modifier
            .size(48.dp)
            .background(
                color = Color(0xFF03578A),
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp)),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color(0xFF03578A),
            contentColor = Color.White
        )
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter),
            contentDescription = "Filter",
            tint = Color.White
        )
    }
}