package com.example.albertsonschallenge.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.albertsonschallenge.databinding.LongformsDisplayBinding
import com.example.albertsonschallenge.model.remote.Lf
import com.example.albertsonschallenge.model.remote.Vars

class SearchScreenAdapter(
    private val currentList: MutableList<Lf> = mutableListOf(),
    private val searchDetails: (List<Vars>) -> Unit
): RecyclerView.Adapter<SearchScreenAdapter.LongformViewHolder>() {
    inner class LongformViewHolder(private val binding: LongformsDisplayBinding):
        RecyclerView.ViewHolder(binding.root){
        fun onBind(dataItem: Lf) {
            binding.Llongform.text = dataItem.lf
            binding.Lfrequency.text = dataItem.freq.toString()
            binding.Lsince.text = dataItem.since.toString()
            binding.root.setOnClickListener { searchDetails(dataItem.vars) }
        }
    }

    fun updateList(list: List<Lf>) {
        currentList.clear()
        currentList.addAll(list)
        notifyDataSetChanged()
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
        holder.onBind(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}