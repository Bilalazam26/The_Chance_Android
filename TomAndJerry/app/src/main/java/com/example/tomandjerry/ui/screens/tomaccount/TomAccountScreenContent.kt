 package com.example.tomandjerry.ui.screens.tomaccount 

 
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tomandjerry.ui.screens.tomaccount.setions.FavouriteFoodsSection
import com.example.tomandjerry.ui.screens.tomaccount.setions.TomSettingsSection
import com.example.tomandjerry.ui.screens.tomaccount.setions.AccountStatesSection
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

 @Composable
fun TomAccountScreenContent(modifier: Modifier = Modifier) {

        Box(
            modifier = modifier
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(Color(0xFFEEF4F6))

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 24.dp),
                horizontalAlignment = CenterHorizontally
            ) {
                AccountStatesSection(
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .padding(horizontal = 16.dp)
                )

                TomSettingsSection(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
                
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    color = Color(0x14001A1F),
                    thickness = 1.dp
                )

                FavouriteFoodsSection(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )

            }

            Text(
                text = "v.TomBeta",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0x99121212),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp)
            )
        }


}

 @Preview(showBackground = true)
 @Composable
 fun TomAccountScreenContentPreview() {
     TomAndJerryTheme {
         TomAccountScreenContent()
     }
 }