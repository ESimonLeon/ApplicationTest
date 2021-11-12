package com.example.testapplication.retrofit

object ApiRoutes {
     const val BASE_URL = "https://community-open-weather-map.p.rapidapi.com/"

     //headers
     const val HEADER_KEY = "x-rapidapi-key: d3fe3a34c5mshf70e1bb90c464a8p1ba4aajsn4233972e8a9c"
     const val HEADER_HOST = "x-rapidapi-host: community-open-weather-map.p.rapidapi.com"

     const val URL_RESPONSE = "weather?q=London%2Cuk&lat=0&lon=0&callback=test&id=2172797&lang=null"
}