package com.example.albertsonschallenge.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.albertsonschallenge.databinding.LongformsDisplayBinding
import com.example.albertsonschallenge.model.remote.AcronymLongforms

class SearchScreenAdapter(
    private var dataset: List<AcronymLongforms>,
    private var openDetails: (AcronymLongforms) -> Unit
) : RecyclerView.Adapter<SearchScreenAdapter.LongformViewHolder>() {
    class LongformViewHolder(private val binding: LongformsDisplayBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBinding(dataItem: AcronymLongforms, openData: (AcronymLongforms) -> Unit) {
            binding.Llongform.text = dataItem.lf
            binding.Lfrequency.text = dataItem.freq
            binding.Lsince.text = dataItem.since
            binding.root.setOnClickListener { openData(dataItem) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LongformViewHolder(
            LongformsDisplayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: LongformViewHolder, position: Int) {
        holder.onBinding(dataset[position], openDetails)
    }

    fun updateList(response: List<AcronymLongforms>) {
        dataset = response
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}