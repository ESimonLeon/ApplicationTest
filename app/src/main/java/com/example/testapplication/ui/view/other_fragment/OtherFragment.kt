package com.example.testapplication.ui.view.other_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapplication.databinding.FragmentOtherBinding
import com.example.testapplication.room.model.CountryTest
import com.example.testapplication.ui.view.other_fragment.adapter.ResponseListAdapter
import com.example.testapplication.ui.view.other_fragment.mvp.IOtherFragmentPresenter
import com.example.testapplication.ui.view.other_fragment.mvp.OtherFragmentPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OtherFragment : Fragment(), IOtherFragmentPresenter.OtherView {

    private lateinit var binding: FragmentOtherBinding

    @Inject
    lateinit var presenter: OtherFragmentPresenter

    companion object {
        fun newInstance() = OtherFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOtherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createRecyclerView()

        presenter.setListerAndLifecycleScope(this, lifecycleScope)

        presenter.getDataList()
    }

    private fun createRecyclerView() = binding.rvList.apply {
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val dividerItemDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        addItemDecoration(dividerItemDecoration)
    }

    override fun setResultList(result: List<CountryTest>) {
        val adapterList = ResponseListAdapter(result)
        binding.rvList.adapter = adapterList
        adapterList.notifyItemChanged(adapterList.itemCount)
    }


}