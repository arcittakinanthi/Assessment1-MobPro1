package com.arcittakinanthi.mobpro1.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.arcittakinanthi.mobpro1.model.Transaksi
import kotlinx.coroutines.launch

class TransaksiViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).transaksiDao()
    val allTransaksi = dao.getAllTransaksi()

    fun insert(nama: String, nominal: String, kategori: String) {
        viewModelScope.launch {
            dao.insert(
                Transaksi(
                    nama = nama,
                    nominal = nominal,
                    kategori = kategori))
        }
    }
    fun update(id: Int, nama: String, nominal: String, kategori: String) {
        viewModelScope.launch {
            dao.update(
                Transaksi(
                    id,
                    nama,
                    nominal,
                    kategori
                )
            )
        }
    }

    fun delete(transaksi: Transaksi) {
        viewModelScope.launch {
            dao.delete(
                transaksi
            )
        }
    }
}