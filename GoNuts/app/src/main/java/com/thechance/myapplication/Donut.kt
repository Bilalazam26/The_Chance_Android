package com.thechance.myapplication

import androidx.compose.ui.graphics.Color

data class Donut(
    val name: String,
    val description: String = "",
    val price: Int,
    val offerPrice: Int = 0,
    val imageRes: Int,
    val cardColor: Color = Color(0xFFD7E4F6)
)
