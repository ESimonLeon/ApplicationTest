package com.example.testapplication.retrofit.response


data class ResTest(
    val coord: ResCoord,
    val weather: ArrayList<ResWeather>,
    val base: String,
    val main: ResMain,
    val visibility: Int,
    val wind: ResWind,
    val clouds: ResClouds,
    val dt: Int,
    val sys: ResSys,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int
) {

    data class ResCoord(val lon: Double, val lat: Double)
    data class ResWeather(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
    )

    data class ResMain(
        val temp: Double,
        val feelslike: Double,
        val tempmin: Double,
        val temp_max: Double,
        val pressure: Int,
        val humidity: Int
    )

    data class ResWind(val speed: Double, val deg: Int)
    data class ResClouds(val all: Int)
    data class ResSys(
        val type: Int,
        val id: Int,
        val country: String,
        val sunrise: Int,
        val sunset: Int
    )
}
