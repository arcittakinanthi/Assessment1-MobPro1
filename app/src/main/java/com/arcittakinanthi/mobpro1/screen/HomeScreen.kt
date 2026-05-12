package com.arcittakinanthi.mobpro1.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.arcittakinanthi.mobpro1.R
import com.arcittakinanthi.mobpro1.database.TransaksiViewModel
import com.arcittakinanthi.mobpro1.model.Transaksi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    listTransaksi: List<Transaksi>,
    onAddClick: () -> Unit,
    viewModel: TransaksiViewModel
) {
    val context = LocalContext.current

    val openDialog = remember { mutableStateOf(false) }
    val selectedTransaksi = remember { mutableStateOf<Transaksi?>(null) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(stringResource(R.string.konfirmasi)) },
            text = { Text(stringResource(R.string.pesan_hapus)) },
            confirmButton = {
                Button(onClick = {
                    selectedTransaksi.value?.let { viewModel.delete(it) }
                }) { Text(stringResource(R.string.ya)) }
            },
            dismissButton = {
                TextButton(onClick = { openDialog.value = false }) { Text(stringResource(R.string.batal)) }
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                actions = {
                    IconButton(onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
                        context.startActivity(intent)
                    }) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
                    }
                    IconButton(onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/arcittakinanthi"))
                        context.startActivity(intent)
                    }) {
                        Icon(imageVector = Icons.Default.Info, contentDescription = "Info")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Icon(Icons.Default.Add, contentDescription = "Tambah")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.apk_ku),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(150.dp)
                        .padding(bottom = 20.dp)
                )
            }

            items(listTransaksi) { transaksi ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp),
                    onClick = {
                        selectedTransaksi.value = transaksi
                        openDialog.value = true
                    }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = transaksi.nama, style = MaterialTheme.typography.titleMedium)
                        Text(text = "Rp ${transaksi.nominal}", color = MaterialTheme.colorScheme.primary)
                        Text(
                            text = "${stringResource(R.string.label_kategori)} ${transaksi.kategori}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}