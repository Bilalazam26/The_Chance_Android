package com.example.tomandjerry.ui.screens.tomkitchen.electrictompasta

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.ui.screens.tomkitchen.electrictompasta.sections.DetailsSection
import com.example.tomandjerry.ui.screens.tomkitchen.electrictompasta.sections.ElectronicPastaHeader
import com.example.tomandjerry.ui.screens.tomkitchen.electrictompasta.sections.PreparationMethodSection
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

@Composable
fun ElectricTomPasta(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(top = 162.dp),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEEF4F6)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
                .padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            ElectronicPastaHeader()
            DetailsSection()
            PreparationMethodSection()

        }

    }
}

@Preview(showBackground = true)
@Composable
fun ElectricTomPastaPreview() {
    TomAndJerryTheme {
        ElectricTomPasta()
    }
}