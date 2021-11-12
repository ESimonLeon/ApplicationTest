package com.example.testapplication.ui.view.other_fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.databinding.ItemReponseBinding
import com.example.testapplication.room.model.CountryTest
import com.example.testapplication.ui.view.other_fragment.adapter.ResponseListAdapter.ResponseListHolder

class ResponseListAdapter(private val result: List<CountryTest>) :
    RecyclerView.Adapter<ResponseListHolder>() {

    class ResponseListHolder(val binding: ItemReponseBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseListHolder {
        return ResponseListHolder(
            ItemReponseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ResponseListHolder, position: Int) {
        holder.binding.countryTest = result[position]
    }

    override fun getItemCount(): Int = result.size

}
