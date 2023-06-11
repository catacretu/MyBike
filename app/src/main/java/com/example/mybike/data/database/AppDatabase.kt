package com.example.mybike.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mybike.data.local.dao.BikeDAO
import com.example.mybike.data.local.dao.RideDAO
import com.example.mybike.data.local.model.BikeEntity
import com.example.mybike.data.local.model.ListTypeConverter
import com.example.mybike.data.local.model.RideEntity

@Database(entities = [BikeEntity::class,RideEntity::class], version = 10)
//@TypeConverters(ListTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getRideDAO(): RideDAO
    abstract fun getBikeDAO(): BikeDAO

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