package com.example.testapplication.room.repo

import com.example.testapplication.retrofit.response.ResTest
import com.example.testapplication.room.dao.TestDao
import com.example.testapplication.room.model.CountryTest
import javax.inject.Inject

class RoomRepository @Inject constructor(private val testDao: TestDao) {

    fun getDataTest() = testDao.getAllData()

    fun saveResponseTest(response: ResTest?) {
        response?.apply {
            testDao.insertResponse(CountryTest(name, coord.lon, coord.lat))
        }
    }

}
