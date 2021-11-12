package com.example.testapplication.ui.view.other_fragment.mvp

import androidx.lifecycle.LifecycleCoroutineScope
import com.example.testapplication.room.model.CountryTest
import com.example.testapplication.ui.view.other_fragment.OtherFragment

interface IOtherFragmentPresenter {

    interface OtherView {
        fun setResultList(result: List<CountryTest>)
    }

    interface OtherPresenter {
        fun setListerAndLifecycleScope(
            otherFragment: OtherFragment,
            lifecycle: LifecycleCoroutineScope
        )

        fun getDataList()
    }

}
