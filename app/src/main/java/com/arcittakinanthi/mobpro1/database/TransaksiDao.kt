package com.arcittakinanthi.mobpro1.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.arcittakinanthi.mobpro1.model.Transaksi
import kotlinx.coroutines.flow.Flow

@Dao
interface TransaksiDao {
    @Query("SELECT * FROM transaksi ORDER BY id DESC")
    fun getAllTransaksi(): Flow<List<Transaksi>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transaksi: Transaksi): Long

    @Update
    suspend fun update(transaksi: Transaksi)

    @Delete
    suspend fun delete(transaksi: Transaksi)
}