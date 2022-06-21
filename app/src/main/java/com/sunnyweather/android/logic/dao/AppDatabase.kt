package com.sunnyweather.android.logic.dao

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sunnyweather.android.logic.entity.CacheEntity
import com.sunnyweather.android.logic.entity.CityEntity

@Database(
    entities = [CacheEntity::class, CityEntity::class],
    version = 1,
    exportSchema = false
)

internal abstract class AppDatabase: RoomDatabase() {
    abstract fun placeDao(): PlaceDao

    abstract fun cityDao(): CityDao

    companion object {
        const val DATABASE_NAME = "sunny_weather.db"


        private var instance: AppDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "app_database")
                .build().apply {
                    instance = this
                }
        }



    }
}
