package com.arcittakinanthi.mobpro1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arcittakinanthi.mobpro1.database.TransaksiViewModel
import com.arcittakinanthi.mobpro1.screen.AddScreen
import com.arcittakinanthi.mobpro1.screen.HomeScreen

@Composable
fun NavGraph(navController: NavHostController, viewModel: TransaksiViewModel) {
    val listTransaksi by viewModel.allTransaksi.collectAsState(initial = emptyList())

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                listTransaksi = listTransaksi,
                onAddClick = { navController.navigate(Screen.Tambah.route) }
            )
        }
        composable(Screen.Tambah.route) {
            AddScreen(
                onBackClick = { navController.popBackStack() },
                onSaveClick = { nama, nom, kat ->
                    viewModel.insert(nama, nom, kat)
                }
            )
        }
    }
}