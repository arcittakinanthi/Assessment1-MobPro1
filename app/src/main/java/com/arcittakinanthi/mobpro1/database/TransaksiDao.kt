package com.arcittakinanthi.mobpro1.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arcittakinanthi.mobpro1.model.Transaksi
import kotlinx.coroutines.flow.Flow

class TransaksiDao {
    @Dao
    interface TransaksiDao {
        @Query("SELECT * FROM transaksi_table ORDER BY id DESC")
        fun getAllTransaksi(): Flow<List<Transaksi>>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(transaksi: Transaksi)
    }
}