package com.example.myapplication.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.model.dao.CountryDao

@Database(entities = [Country::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao
}