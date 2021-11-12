package com.example.testapplication.room.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "country_test", indices = [Index(value = ["id"], unique = true)])
data class CountryTest(
    val name: String? = null,
    val lon: Double = 0.0,
    val lat: Double = 0.0,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)