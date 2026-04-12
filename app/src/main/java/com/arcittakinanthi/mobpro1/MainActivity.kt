package com.arcittakinanthi.mobpro1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arcittakinanthi.mobpro1.model.Transaksi
import com.arcittakinanthi.mobpro1.ui.theme.HomeScreen
import com.arcittakinanthi.mobpro1.ui.theme.ManajerUangkuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ManajerUangkuTheme {
                val listDummy = listOf(
                    Transaksi("Beli Bakso", "20000", "Makanan"),
                    Transaksi("Ongkos Angkot", "5000", "Transport")
                )

                HomeScreen(
                    listTransaksi = listDummy,
                    onAddClick = { /* Nanti buat pindah ke screen tambah */ }
                )
            }
        }
    }
}
