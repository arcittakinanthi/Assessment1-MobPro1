package com.arcittakinanthi.mobpro1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.arcittakinanthi.mobpro1.database.TransaksiViewModel
import com.arcittakinanthi.mobpro1.screen.AddScreen
import com.arcittakinanthi.mobpro1.screen.EditScreen
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
                onAddClick = { navController.navigate(Screen.Tambah.route) },
                viewModel = viewModel
            )
        }
        composable(Screen.Tambah.route) {
            AddScreen(
                onBackClick = { navController.popBackStack() },
                onSaveClick = { nama, nom, kat ->
                    viewModel.insert(
                        nama,
                        nom,
                        kat
                    )
                }
            )
        }
        composable(
            route = "edit/{transaksiId}",
            arguments = listOf(navArgument("transaksiId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("transaksiId") ?: 0
            EditScreen(
                transaksiId = id,
                onBackClick = { navController.popBackStack() },
                viewModel = viewModel
            )
        }
    }
}