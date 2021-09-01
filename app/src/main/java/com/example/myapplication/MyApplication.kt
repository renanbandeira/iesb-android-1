package com.example.myapplication

import android.app.Application
import androidx.room.Room
import com.example.myapplication.model.AppDatabase

class MyApplication : Application() {

    companion object {
        var database: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "country_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}