package com.arcittakinanthi.mobpro1.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arcittakinanthi.mobpro1.model.Transaksi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    listTransaksi: List<Transaksi>,
    onAddClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Manajer Uangku") },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Info, contentDescription = "Tentang Aplikasi")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Icon(Icons.Default.Add, contentDescription = "Tambah Transaksi")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listTransaksi) { transaksi ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = transaksi.nama, style = MaterialTheme.typography.titleMedium)
                        Text(text = "Rp ${transaksi.nominal}", style = MaterialTheme.typography.bodyMedium)
                        Text(text = "Kategori: ${transaksi.kategori}", style = MaterialTheme.typography.labelSmall)
                    }
                }
            }
        }
    }
}