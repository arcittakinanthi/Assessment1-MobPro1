package com.arcittakinanthi.mobpro1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arcittakinanthi.mobpro1.model.Transaksi
import com.arcittakinanthi.mobpro1.screen.AddScreen
import com.arcittakinanthi.mobpro1.screen.HomeScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    listTransaksi: MutableList<Transaksi>
) {
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
                onSaveClick = { nama, nominal, kategori ->
                    listTransaksi.add(Transaksi(nama, nominal, kategori))
                }
            )
        }
    }
}