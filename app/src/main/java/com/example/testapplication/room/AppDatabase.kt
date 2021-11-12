package com.example.testapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapplication.room.dao.TestDao
import com.example.testapplication.room.model.CountryTest


@Database(entities = [CountryTest::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun testDao(): TestDao
}
