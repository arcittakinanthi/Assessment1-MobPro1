package com.arcittakinanthi.mobpro1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arcittakinanthi.mobpro1.model.Transaksi


@Database(entities = [Transaksi::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transaksiDao(): TransaksiDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "transaksi_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}