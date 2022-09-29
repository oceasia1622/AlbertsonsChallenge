package com.example.albertsonschallenge.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.albertsonschallenge.databinding.ContainerBinding
import com.example.albertsonschallenge.model.remote.AcronymLongforms

class SearchScreenAdapter(
    private var dataset: List<AcronymLongforms>,
    private var openDetails:(AcronymLongforms) -> Unit)
    : RecyclerView.Adapter<SearchScreenAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBinding(dataItem: AcronymLongforms, openData: (AcronymLongforms) -> Unit) {
            binding.tvlf.text = dataItem.lf
            binding.tvfreq.text = dataItem.freq
            binding.tvsince.text = dataItem.since
            binding.root.setOnClickListener { openData(dataItem) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return SearchScreenAdapter.ViewHolder(
            ContainerBinding
                .inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBinding(dataset[position], openDetails)
    }

    fun updateList(response: List<AcronymLongforms>){
        dataset = response
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}