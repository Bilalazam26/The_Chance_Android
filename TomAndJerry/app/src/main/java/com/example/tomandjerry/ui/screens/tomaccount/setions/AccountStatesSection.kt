package com.example.tomandjerry.ui.screens.tomaccount.setions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.screens.tomaccount.components.AccountStateItem

@Composable
fun AccountStatesSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = CenterVertically
        ) {
            AccountStateItem(
                iconRes = R.drawable.ic_evel_account,
                title = "2M 12K",
                text = "No. of quarrels",
                containerColor = Color(0xFFD0E5F0),
                modifier = Modifier
                    .weight(1f)
            )

            AccountStateItem(
                iconRes = R.drawable.ic_chase_time_account,
                title = "+500 h",
                text = "Chase time",
                containerColor = Color(0xFFDEEECD),
                modifier = Modifier
                    .weight(1f)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = CenterVertically
        ) {
            AccountStateItem(
                iconRes = R.drawable.ic_hunting_account,
                title = "2M 12K",
                text = "Hunting times",
                containerColor = Color(0xFFF2D9E7),
                modifier = Modifier
                    .weight(1f)
            )

            AccountStateItem(
                iconRes = R.drawable.ic_heartbroken_account,
                title = "3M 7K",
                text = "Heartbroken",
                containerColor = Color(0xFFFAEDCF),
                modifier = Modifier
                    .weight(1f)
            )
        }
    }

}