package com.arcittakinanthi.mobpro1.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Tambah : Screen("tambah")
}