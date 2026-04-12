package com.arcittakinanthi.mobpro1.ui.theme

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(onBackClick: () -> Unit) {
    var nama by remember { mutableStateOf("") }
    var nominal by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tambah Transaksi") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama Transaksi") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = nominal,
                onValueChange = { nominal = it },
                label = { Text("Nominal (Rp)") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    if (nama.isEmpty() || nominal.isEmpty()) {
                        Toast.makeText(context, "Data tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show()
                        onBackClick()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Simpan Transaksi")
            }
        }
    }
}