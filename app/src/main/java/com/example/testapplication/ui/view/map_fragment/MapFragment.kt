package com.example.testapplication.ui.view.map_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.testapplication.R
import com.example.testapplication.databinding.FragmentMapBinding
import com.example.testapplication.room.model.CountryTest
import com.example.testapplication.ui.view.map_fragment.mvp.IMapFragmentPresenter
import com.example.testapplication.ui.view.map_fragment.mvp.MapFragmentPresenter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MapFragment : Fragment(), IMapFragmentPresenter.MapView, OnMapReadyCallback {

    private lateinit var binding: FragmentMapBinding

    private lateinit var mGoogleMap: GoogleMap

    @Inject
    lateinit var presenter: MapFragmentPresenter

    companion object {
        fun newInstance() = MapFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.setListerAndLifecycleScope(this, lifecycleScope)

        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap

        presenter.getDataCoord()
    }

    override fun setResultCoord(result: List<CountryTest>) {
        mGoogleMap.clear()
        result.forEach { item ->
            mGoogleMap.addMarker(MarkerOptions().position(LatLng(item.lat, item.lon)).title(item.name))
            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(item.lat, item.lon)))
        }
    }
}