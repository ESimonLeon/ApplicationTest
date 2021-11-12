package com.example.testapplication.ui.mvp_main

import com.example.testapplication.retrofit.response.ResTest
import com.example.testapplication.ui.MainActivity

interface IMainActivityPresenter {

    interface MainView {
        fun setOnFailure(t: Throwable)
    }

    interface MainPresenter {
        fun setMainListener(mainActivity: MainActivity)
        fun getData()
        fun setResponse(response: ResTest?)
        fun setFailure(t: Throwable)
    }
}
