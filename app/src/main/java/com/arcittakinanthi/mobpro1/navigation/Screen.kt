package com.arcittakinanthi.mobpro1.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Tambah : Screen("add_screen")
}