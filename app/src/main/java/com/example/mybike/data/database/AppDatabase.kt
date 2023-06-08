package com.example.mybike.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mybike.data.local.dao.RideDAO
import com.example.mybike.data.local.model.RideEntity

@Database(entities = [RideEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getRideDAO(): RideDAO

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java,
                    "BikeDatabase"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build()
            }
            return INSTANCE!!
        }
    }

}