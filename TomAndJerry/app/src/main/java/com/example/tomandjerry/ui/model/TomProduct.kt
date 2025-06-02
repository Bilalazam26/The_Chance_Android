package com.example.tomandjerry.ui.model

data class TomProduct(
    val name: String,
    val description: String,
    val imageRes: Int,
    val price: Int,
    val isDiscount: Boolean = false,
    val oldPrice: Int = 0
)

