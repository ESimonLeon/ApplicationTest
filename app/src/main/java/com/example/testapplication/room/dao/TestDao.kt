package com.example.testapplication.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testapplication.room.model.CountryTest

@Dao
interface TestDao {

    @Query("SELECT * FROM country_test ")
    fun getAllData(): List<CountryTest>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertResponse(countryTest: CountryTest)

}
