package com.example.tomandjerry.ui.screens.jerrystore.cheaptomsection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.model.TomProduct
import com.example.tomandjerry.ui.screens.jerrystore.cheaptomsection.components.CheapTomSectionHeader
import com.example.tomandjerry.ui.screens.jerrystore.cheaptomsection.components.TomProductCard

@Composable
fun CheapTomSection(
    scrollState: LazyGridState,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val tomProductLists = listOf(
        TomProduct("Sport Tom", "He runs 1 meter... trips\nover his boot.\n", R.drawable.tom1, 3, true, 5),
        TomProduct("Tom the lover", "He loves one-sidedly...\nand is beaten by the other\nside.", R.drawable.tom2, 5),
        TomProduct("Tom the bomb", "He blows himself up\nbefore Jerry can catch\nhim.", R.drawable.tom3, 10),
        TomProduct("Spy Tom", "Disguises itself as a table.", R.drawable.tom4, 12),
        TomProduct("Frozen Tom", "He was chasing Jerry, he\nfroze after the first look\n", R.drawable.tom5, 10),
        TomProduct("Sleeping Tom", "He doesn't chase anyone,\nhe just snores in stereo.\n", R.drawable.tom6, 10),
        TomProduct("Sport Tom", "He runs 1 meter... trips\nover his boot.\n", R.drawable.tom1, 3, true, 5),
        TomProduct("Tom the lover", "He loves one-sidedly...\nand is beaten by the other\nside.", R.drawable.tom2, 5),
        TomProduct("Tom the bomb", "He blows himself up\nbefore Jerry can catch\nhim.", R.drawable.tom3, 10),
        TomProduct("Spy Tom", "Disguises itself as a table.", R.drawable.tom4, 12),
        TomProduct("Frozen Tom", "He was chasing Jerry, he\nfroze after the first look\n", R.drawable.tom5, 10),
        TomProduct("Sleeping Tom", "He doesn't chase anyone,\nhe just snores in stereo.\n", R.drawable.tom6, 10),
    )

    CheapTomSectionHeader()

    Spacer(modifier = Modifier.height(16.dp))

    LazyVerticalGrid(
        state = scrollState,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(max = screenHeight)
    ) {
        items(tomProductLists) { tom ->
            TomProductCard(tom)
        }
    }
}