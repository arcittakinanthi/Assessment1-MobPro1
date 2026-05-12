package com.arcittakinanthi.mobpro1.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.arcittakinanthi.mobpro1.R
import com.arcittakinanthi.mobpro1.database.TransaksiViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(
    transaksiId: Int,
    onBackClick: () -> Unit,
    viewModel: TransaksiViewModel
) {
    val context = LocalContext.current
    val listTransaksi by viewModel.allTransaksi.collectAsState(initial = emptyList())
    val transaksiDetail = listTransaksi.find { it.id == transaksiId }

    var nama by remember { mutableStateOf("") }
    var nominal by remember { mutableStateOf("") }
    var kategori by remember { mutableStateOf("") }

    LaunchedEffect(transaksiDetail) {
        transaksiDetail?.let {
            nama = it.nama
            nominal = it.nominal
            kategori = it.kategori
        }
    }

    val options = listOf(
        stringResource(R.string.kat_makanan),
        stringResource(R.string.kat_transport),
        stringResource(R.string.kat_lainnya)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.edit_data)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text(stringResource(R.string.label_nama)) },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = nominal,
                onValueChange = { nominal = it },
                label = { Text(stringResource(R.string.label_nominal)) },
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
            )

            Text(text = stringResource(R.string.label_kategori), modifier = Modifier.padding(top = 16.dp))
            options.forEach { text ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = (text == kategori), onClick = { kategori = text })
                    Text(text = text)
                }
            }

            Button(
                onClick = {
                    if (nama.isNotEmpty() && nominal.isNotEmpty()) {
                        viewModel.update(transaksiId, nama, nominal, kategori)
                        Toast.makeText(context, context.getString(R.string.msg_updated), Toast.LENGTH_SHORT).show()
                        onBackClick()
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
            ) {
                Text(stringResource(R.string.btn_update))
            }
        }
    }
}