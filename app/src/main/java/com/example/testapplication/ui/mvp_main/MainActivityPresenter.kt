package com.example.testapplication.ui.mvp_main

import com.example.testapplication.retrofit.repo.ApiRepository
import com.example.testapplication.retrofit.response.ResTest
import com.example.testapplication.room.repo.RoomRepository
import com.example.testapplication.ui.MainActivity
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(
    private val apiRepository: ApiRepository,
    private val roomRepository: RoomRepository
) : IMainActivityPresenter.MainPresenter {

    lateinit var mainView: IMainActivityPresenter.MainView

    init {
        apiRepository.setPresenter(this)
    }

    override fun setMainListener(mainActivity: MainActivity) {
        mainView = mainActivity
    }

    override fun getData() = apiRepository.getDataApi()

    override fun setResponse(response: ResTest?) = Thread {
        roomRepository.saveResponseTest(response)
    }.start()

    override fun setFailure(t: Throwable) {
        mainView.setOnFailure(t)
    }
}
