package com.example.tomandjerry.ui.screens.jerrystore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.ui.screens.jerrystore.components.promotionbanner.PromotionBanner
import com.example.tomandjerry.ui.screens.jerrystore.components.searchbar.JerryStoreSearchBarContainer
import com.example.tomandjerry.ui.screens.jerrystore.cheaptomsection.CheapTomSection
import com.example.tomandjerry.ui.screens.jerrystore.components.appbar.JerryStoreAppBar

@Composable
fun JerryStoreScreenContent(modifier: Modifier = Modifier) {
    /*
    The Problem is :
     Compose’s nested scrolling system automatically dispatches unconsumed scroll delta down the hierarchy of nested scrollable components,
      and this is ok in all cases except one case :
        - when the outer scrollable isn't scrolled down yet && also inner grid is not scrolled down yet, Compose will let the inner grid scrolls down.
        - In this case the outer Column is taking large portion of the screen, So I want it to be scrolled first.
     */
    //handle nested scrolling
    val outerScrollState = rememberScrollState()
    val innerGridScrollState = rememberLazyGridState()

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                /*
                when the delta is negative -> scrolling down
                when the delta is positive -> scrolling up
                 */
                return if (delta < 0 && outerScrollState.value < outerScrollState.maxValue) {//scrolling down && the outer Column didn't reach the bottom yet
                    val consumed =
                        outerScrollState.dispatchRawDelta(-delta) //scroll the outer Column
                    Offset(0f, -consumed)
                } else {
                    Offset.Zero //In all other cases let compose handle it itself
                }
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
            .verticalScroll(outerScrollState)
            .padding(
                horizontal = 16.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        JerryStoreSearchBarContainer()
        Spacer(modifier = Modifier.height(8.dp))

        PromotionBanner()
        Spacer(modifier = Modifier.height(24.dp))


        CheapTomSection(
            scrollState = innerGridScrollState
        )

    }
}