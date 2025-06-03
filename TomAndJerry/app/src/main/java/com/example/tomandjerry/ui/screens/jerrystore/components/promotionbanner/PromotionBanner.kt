package com.example.tomandjerry.ui.screens.jerrystore.components.promotionbanner

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tomandjerry.R
import com.example.tomandjerry.ui.theme.TomAndJerryTheme


@Composable
fun PromotionBanner(modifier: Modifier = Modifier) {
    val bannerHeight = 92.dp
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(108.dp),
    ) {
        Box(
            modifier = Modifier
                .height(bannerHeight)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF03446A), Color(0xFF0685D0))
                    )
                )
                .align(Alignment.BottomCenter)
        ) {
            PromotionBannerBackground(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(bannerHeight)
            )

            Column(
                modifier = Modifier
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Buy 1 Tom and get 2 for free",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Adopt Tom! (Free Fail-Free Guarantee)",
                    modifier = Modifier
                        .size(177.dp, 36.dp),
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 12.sp,
                    style = TextStyle(
                        lineHeight = 18.sp,
                        letterSpacing = 0.sp
                    ),
                    maxLines = 2
                )
            }
        }

        /*Image(
            painter = painterResource(id = R.drawable.tom_banner),
            contentDescription = null,
            contentScale = ContentScale.None,
            alignment = TopStart,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                //.offset(y = 68.dp, x = 76.dp)
                .graphicsLayer(scaleX = .7f, scaleY = .7f)
                .align(Alignment.CenterEnd)
        )*/
        Image(
            painter = painterResource(id = R.drawable.tom_banner),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .padding(top = 30.dp)
                .offset(x = 2.dp)
                .size(width = 116.dp, height = 108.dp)
                .graphicsLayer(scaleX = 1.65f, scaleY = 1.65f)
                .align(Alignment.CenterEnd)
        )

        /*Image(
            painter = painterResource(id = R.drawable.tom_promotion_banner_image),
            contentDescription = null,
            modifier = Modifier
                .size(width = 116.dp, height = 108.dp)
                .align(Alignment.CenterEnd)
        )*/

    }
}
@Preview(showBackground = true)
@Composable
fun PromotionBannerPreview() {
    TomAndJerryTheme {
        PromotionBanner()
    }
}