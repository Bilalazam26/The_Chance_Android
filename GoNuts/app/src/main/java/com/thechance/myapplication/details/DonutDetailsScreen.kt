package com.thechance.myapplication.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale.Companion.FillBounds
import androidx.compose.ui.layout.ContentScale.Companion.Fit
import androidx.compose.ui.layout.ContentScale.Companion.Inside
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.myapplication.Donut
import com.thechance.myapplication.R
import com.thechance.myapplication.core.BoxedIcon
import com.thechance.myapplication.core.GonutsButton
import com.thechance.myapplication.details.components.Counter
import com.thechance.myapplication.ui.theme.GoNutsTheme

@Composable
fun DonutDetailsScreen(
    donut: Donut,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(id = donut.imageRes),
            contentDescription = "Donuts",
            contentScale = Fit,
            modifier = Modifier
                .padding(horizontal = 64.dp)
                .padding(top = 32.dp)
                .fillMaxWidth()
                .fillMaxHeight(.35f)
                .align(TopCenter)

        )
        Box(
            modifier = Modifier
                .align(BottomCenter)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 40.dp,
                            topEnd = 40.dp
                        )
                    )
                    .background(color = White)
                    .padding(40.dp)

                    .align(BottomCenter),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = donut.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.size(32.dp))

                Text(
                    text = "About Gonuts",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black.copy(alpha = 0.8f),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.size(16.dp))

                Text(
                    text = donut.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black.copy(alpha = 0.6f),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.size(26.dp))

                Text(
                    text = "Quantity",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black.copy(alpha = 0.8f),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start
                )


                Spacer(modifier = Modifier.height(18.dp))

                Counter()

                Spacer(modifier = Modifier.height(46.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(26.dp)
                ) {
                    Text(
                        text = "£${donut.price}",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Black,
                        modifier = Modifier
                            .weight(1f),
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )

                    GonutsButton(
                        text = "Add to Cart",
                        modifier = Modifier
                            .weight(5f),
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = White
                    )

                }
            }

            BoxedIcon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_favourite),
                contentDescription = "Favourite",
                containerColor = White,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(45.dp)
                    .offset(y = (-22).dp, x = (-35).dp)
                    .align(Alignment.TopEnd)
                    .shadow(8.dp, RoundedCornerShape(16.dp))
            )
        }



        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_back),
            contentDescription = "Back",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .size(30.dp)
                .offset(y = 45.dp, x = 32.dp)
                .align(Alignment.TopStart)
                .clickable { onBackClick() }
        )
    }
}

@Preview
@Composable
fun DonutDetailsScreenPreview() {
    GoNutsTheme {
        DonutDetailsScreen(
            donut = Donut(
                "Strawberry Wheel",
                "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                16,
                16,
                R.drawable.donut_offer_1_image
            )
        )
    }
}