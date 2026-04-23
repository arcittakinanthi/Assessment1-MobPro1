package com.arcittakinanthi.mobpro1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.arcittakinanthi.mobpro1.model.Transaksi
import com.arcittakinanthi.mobpro1.navigation.NavGraph
import com.arcittakinanthi.mobpro1.screen.TransaksiData
import com.arcittakinanthi.mobpro1.ui.theme.ManajerUangkuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ManajerUangkuTheme {
                val navController = rememberNavController()
                val listTransaksi = remember {
                    mutableStateListOf<Transaksi>().apply {
                        addAll(TransaksiData.listDummy)
                    }
                }
                NavGraph(
                    navController = navController,
                    listTransaksi = listTransaksi
                )
            }
        }
    }
}