package com.example.testapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testapplication.R
import com.example.testapplication.databinding.ActivityMainBinding
import com.example.testapplication.ui.mvp_main.IMainActivityPresenter
import com.example.testapplication.ui.mvp_main.MainActivityPresenter
import com.example.testapplication.ui.view.FirstFragment
import com.example.testapplication.ui.view.map_fragment.MapFragment
import com.example.testapplication.ui.view.other_fragment.OtherFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), IMainActivityPresenter.MainView {

    private lateinit var binding: ActivityMainBinding

    private val firstFragment = FirstFragment.newInstance()
    private val mapFragment = MapFragment.newInstance()
    private val otherFragment = OtherFragment.newInstance()

    @Inject
    lateinit var presenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.setMainListener(this)

        initFragment()

        loadListeners()
    }

    private fun initFragment() = supportFragmentManager.beginTransaction().also {
        it.add(binding.fragmentContainer.id, firstFragment)
    }.commit()

    private fun loadListeners() = binding.apply {
        buttonFirstFragment.setOnClickListener { goToFirstFragment() }
        buttonMapFragment.setOnClickListener { goMapFragment() }
        buttonOtherFragment.setOnClickListener { goOtherFragment() }
    }

    private fun goToFirstFragment() {
        replaceFragment(firstFragment)
    }

    private fun goMapFragment() = presenter.apply {
        getData()
        replaceFragment(mapFragment)
    }

    private fun goOtherFragment() = presenter.apply {
        getData()
        replaceFragment(otherFragment)
    }

    private fun replaceFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().also {
            it.replace(binding.fragmentContainer.id, fragment)
            it.addToBackStack(null)
        }.commit()

    override fun setOnFailure(t: Throwable) {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.an_error_occurred))
            .setMessage(t.localizedMessage).setPositiveButton(
                getString(R.string.close_alert)
            ) { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }

}