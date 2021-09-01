package com.example.myapplication.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.model.Country

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCountries(countries: List<Country>)

    @get:Query("SELECT * FROM Country")
    val countries: LiveData<List<Country>>

    @Query("DELETE FROM Country")
    fun deleteAll()
}