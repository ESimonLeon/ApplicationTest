package com.example.testapplication.retrofit

import com.example.testapplication.retrofit.ApiRoutes.URL_RESPONSE
import com.example.testapplication.retrofit.ApiRoutes.HEADER_HOST
import com.example.testapplication.retrofit.ApiRoutes.HEADER_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiServiceInterface {

    @Headers(HEADER_KEY, HEADER_HOST)
    @GET(URL_RESPONSE)
    fun getResponseTest(): Call<String>
}
