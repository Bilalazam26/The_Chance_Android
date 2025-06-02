package com.thechance.myapplication.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.myapplication.Donut
import com.thechance.myapplication.R
import com.thechance.myapplication.core.BoxedIcon

@Composable
fun DonutOfferItem(
    donut: Donut,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .size(193.dp, 325.dp)
            .clickable { onClick() },
    ) {
        Column(
            modifier = Modifier
                .height(325.dp)
                .width(193.dp)
                .shadow(
                    elevation = 16.dp,
                    shape = RoundedCornerShape(20.dp),
                    clip = false,
                    spotColor = Black.copy(alpha = 0.3f),
                    ambientColor = Black.copy(alpha = 0.3f)
                )
                .background(
                    color = donut.cardColor,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(16.dp)
        ) {
            BoxedIcon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_favourite),
                contentDescription = "Favourite",
                tint = MaterialTheme.colorScheme.primary,
                containerColor = White,
                shape = CircleShape,
                modifier = Modifier
                    .size(35.dp)
                    .align(Alignment.Start)
            )

            Spacer(
                modifier = Modifier
                    .height(152.dp)
            )

            Text(
                text = donut.name,
                style = MaterialTheme.typography.titleSmall,
                color = Black,
                modifier = Modifier
                    .align(Alignment.Start),
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = donut.description,
                style = MaterialTheme.typography.bodySmall,
                color = Black.copy(alpha = 0.6f),
                modifier = Modifier
                    .align(Alignment.Start),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(
                modifier = Modifier
                    .height(8.dp)
            )

            Row(
                modifier = Modifier
                    .align(Alignment.End),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "${donut.price}$",
                    style = MaterialTheme.typography.labelMedium,
                    color = Black.copy(alpha = 0.42f),
                    textDecoration = TextDecoration.LineThrough
                )

                Text(
                    text = "${donut.offerPrice}$",
                    style = MaterialTheme.typography.labelLarge,
                    color = Black,
                )
            }

        }

        Image(
            painter = painterResource(id = donut.imageRes),
            contentDescription = donut.name,
            contentScale = Crop,
            modifier = Modifier
                .size(136.dp)
                .align(Alignment.TopEnd)
                .offset(x = 36.dp, y = 50.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DonutOfferItemPreview() {
    DonutOfferItem(
        donut = Donut(
            "Strawberry Wheel",
            "These Baked Strawberry Donuts are filled with fresh strawberries...",
            20,
            16,
            R.drawable.donut_offer_1_image
        ),
        modifier = Modifier
            .size(325.dp)
    )
}