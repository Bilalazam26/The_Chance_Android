package com.example.tomandjerry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.tomandjerry.ui.screens.jerrystore.JerryStoreScreen
import com.example.tomandjerry.ui.screens.secretepisodes.SecretEpisodesScreen
import com.example.tomandjerry.ui.screens.tomaccount.TomAccountScreen
import com.example.tomandjerry.ui.screens.tomkitchen.TomKitchenScreen
import com.example.tomandjerry.ui.theme.TomAndJerryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TomAndJerryTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color(0xFFEEF4F6)
                ) { innerPadding ->
                    /*JerryStoreScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )*/

                    /*TomKitchenScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )*/

                    TomAccountScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )

                    /*SecretEpisodesScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )*/
                }
            }
        }
    }
}
