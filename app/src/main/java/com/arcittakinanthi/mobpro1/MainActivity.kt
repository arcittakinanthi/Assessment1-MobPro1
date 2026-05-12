package com.arcittakinanthi.mobpro1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.arcittakinanthi.mobpro1.database.TransaksiViewModel
import com.arcittakinanthi.mobpro1.navigation.NavGraph
import com.arcittakinanthi.mobpro1.ui.theme.ManajerUangkuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ManajerUangkuTheme {
                val navController = rememberNavController()

                val viewModel: TransaksiViewModel = viewModel()

                NavGraph(
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }
    }
}