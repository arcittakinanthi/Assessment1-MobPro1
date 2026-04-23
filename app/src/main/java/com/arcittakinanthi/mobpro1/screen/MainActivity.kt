package com.arcittakinanthi.mobpro1.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.arcittakinanthi.mobpro1.navigation.NavGraph
import com.arcittakinanthi.mobpro1.ui.theme.ManajerUangkuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ManajerUangkuTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}