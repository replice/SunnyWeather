package com.sunnyweather.android.logic.dao

import androidx.room.*
import com.sunnyweather.android.logic.entity.CityEntity

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCity(city: CityEntity): Long

    @Query("select * from city")
    fun getCities(): List<CityEntity>

    @Query("delete from city where cityId=:id")
    fun removeCity(id: String)

    @Query("delete from city")
    fun removeAllCity()

}