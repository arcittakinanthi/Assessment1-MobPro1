package com.arcittakinanthi.mobpro1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaksi")
data class Transaksi(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val nominal: String,
    val kategori: String
)