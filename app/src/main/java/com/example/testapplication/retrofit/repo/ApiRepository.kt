package com.example.testapplication.retrofit.repo

import com.example.testapplication.ui.mvp_main.IMainActivityPresenter
import com.example.testapplication.ui.mvp_main.MainActivityPresenter
import com.example.testapplication.retrofit.ApiServiceInterface
import com.example.testapplication.retrofit.response.ResTest
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository(private val apiServiceInterface: ApiServiceInterface) {

    lateinit var presenter: IMainActivityPresenter.MainPresenter

    fun setPresenter(mainActivityPresenter: MainActivityPresenter) {
        presenter = mainActivityPresenter
    }

    fun getDataApi() = apiServiceInterface.getResponseTest().enqueue(object : Callback<String> {
        override fun onResponse(call: Call<String>, response: Response<String>) {
            if (response.isSuccessful) createResponse(response.body().toString())
        }

        override fun onFailure(call: Call<String>, t: Throwable) {
            presenter.setFailure(t)
        }
    })

    private fun createResponse(response: String) {
        val json = response.split("test(")[1].split(")")
        presenter.setResponse(Gson().fromJson(json[0], ResTest::class.java))
    }

}
