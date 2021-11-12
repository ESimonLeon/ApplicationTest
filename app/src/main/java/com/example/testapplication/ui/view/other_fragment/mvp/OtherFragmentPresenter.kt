package com.example.testapplication.ui.view.other_fragment.mvp

import androidx.lifecycle.LifecycleCoroutineScope
import com.example.testapplication.room.model.CountryTest
import com.example.testapplication.room.repo.RoomRepository
import com.example.testapplication.ui.view.other_fragment.OtherFragment
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OtherFragmentPresenter @Inject constructor(private val roomRepository: RoomRepository) :
    IOtherFragmentPresenter.OtherPresenter {

    private var listReponse: List<CountryTest> = emptyList()

    private lateinit var otherView: IOtherFragmentPresenter.OtherView
    private lateinit var lifecycleLaunch: LifecycleCoroutineScope

    override fun setListerAndLifecycleScope(
        otherFragment: OtherFragment,
        lifecycle: LifecycleCoroutineScope
    ) {
        otherView = otherFragment
        lifecycleLaunch = lifecycle

    }

    override fun getDataList() {
        lifecycleLaunch.launch {
            listReponse = withContext(IO) {
                roomRepository.getDataTest()
            }
            otherView.setResultList(listReponse)
        }
    }
}