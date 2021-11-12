package com.example.testapplication.ui.view.map_fragment.mvp

import androidx.lifecycle.LifecycleCoroutineScope
import com.example.testapplication.room.model.CountryTest
import com.example.testapplication.ui.view.map_fragment.MapFragment

interface IMapFragmentPresenter {

    interface MapView {
        fun setResultCoord(result: List<CountryTest>)
    }

    interface MapPresenter {
        fun setListerAndLifecycleScope(mapFragment: MapFragment, lifecycle: LifecycleCoroutineScope)
        fun getDataCoord()
    }
}
