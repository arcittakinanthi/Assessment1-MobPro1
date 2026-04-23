package com.arcittakinanthi.mobpro1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arcittakinanthi.mobpro1.screen.TransaksiData
import com.arcittakinanthi.mobpro1.ui.theme.AddScreen
import com.arcittakinanthi.mobpro1.ui.theme.HomeScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                listTransaksi = TransaksiData.listDummy,
                onAddClick = { navController.navigate(Screen.Tambah.route) }
            )
        }
        composable(Screen.Tambah.route) {
            AddScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}