package com.example.tomandjerry.ui.screens.tomkitchen.electrictompasta.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.core.PriceContainer

@Composable
fun ElectronicPastaHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Electric Tom pasta",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 20.sp
                    ),
                    color = Color(0xDE1F1F1E)
                )

                PriceContainer(
                    price = 5,
                    containerColor = Color(0xFFD0E5F0)
                )
            }

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_favourite),
                contentDescription = "Add to cart",
                tint = Color(0xFF03578A)
            )
        }

        Text(
            text = "Pasta cooked with a charger cable and sprinkled with questionable cheese. Make sure to unplug it before eating (or not, you decide).",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 16.sp
            ),
            color = Color(0x99121212),
            modifier = Modifier
                .padding(end = 8.dp)
        )
    }
}