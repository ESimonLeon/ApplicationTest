package com.example.testapplication.ui.view.map_fragment.mvp

import androidx.lifecycle.LifecycleCoroutineScope
import com.example.testapplication.room.model.CountryTest
import com.example.testapplication.room.repo.RoomRepository
import com.example.testapplication.ui.view.map_fragment.MapFragment
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MapFragmentPresenter @Inject constructor(private val roomRepository: RoomRepository) :
    IMapFragmentPresenter.MapPresenter {

    private var listReponse: List<CountryTest> = emptyList()

    private lateinit var mapsView: IMapFragmentPresenter.MapView
    private lateinit var lifecycleLaunch: LifecycleCoroutineScope

    override fun setListerAndLifecycleScope(
        mapFragment: MapFragment,
        lifecycle: LifecycleCoroutineScope
    ) {
        mapsView = mapFragment
        lifecycleLaunch = lifecycle
    }

    override fun getDataCoord() {
        lifecycleLaunch.launch {
            listReponse = withContext(IO) {
                roomRepository.getDataTest()
            }
            mapsView.setResultCoord(listReponse)
        }

    }
}