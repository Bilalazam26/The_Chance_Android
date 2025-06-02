package com.thechance.myapplication.home

import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.thechance.myapplication.R
import com.thechance.myapplication.core.GoNutsBadgedIcon

@Composable
fun HomeBottomBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier
                .size(35.dp),
            onClick = {}
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_home),
                contentDescription = "Home",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        IconButton(
            modifier = Modifier
                .size(35.dp),
            onClick = {}
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_favourites),
                contentDescription = "Favourites",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        IconButton(
            modifier = Modifier
                .size(35.dp),
            onClick = {}
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_notification),
                contentDescription = "Notifications",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        GoNutsBadgedIcon(
            badgeText = "2",
            icon = R.drawable.ic_cart,
            modifier = Modifier
                .size(35.dp)
        )

        IconButton(
            modifier = Modifier
                .size(35.dp),
            onClick = {}
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_profile),
                contentDescription = "Profile",
                tint = MaterialTheme.colorScheme.primary
            )
        }


    }

}

