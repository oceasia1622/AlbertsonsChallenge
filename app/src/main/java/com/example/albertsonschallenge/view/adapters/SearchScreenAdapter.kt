package com.example.albertsonschallenge.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.albertsonschallenge.databinding.LongformsDisplayBinding
import com.example.albertsonschallenge.model.remote.AcronymItem
import com.example.albertsonschallenge.model.remote.Lf
import com.example.albertsonschallenge.model.remote.SearchResponse

class SearchScreenAdapter(private var currentList: SearchResponse, private var searchDetails: (AcronymItem) -> Unit):
    ListAdapter<Lf, SearchScreenAdapter.LongformViewHolder>(LongformDiffUtil) {
    class LongformViewHolder(private val binding: LongformsDisplayBinding):
        RecyclerView.ViewHolder(binding.root){
        fun onBind(dataItem: AcronymItem, openData: (AcronymItem) -> Unit) {
            binding.Llongform.text = dataItem.lfs.first().lf
            binding.Lfrequency.text = dataItem.lfs.first().freq.toString()
            binding.Lsince.text = dataItem.lfs.first().since.toString()
            binding.root.setOnClickListener { openData(dataItem) }
        }
    }

    object LongformDiffUtil: DiffUtil.ItemCallback<Lf>(){
        override fun areItemsTheSame(oldItem: Lf, newItem: Lf): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: Lf, newItem: Lf): Boolean {
            return oldItem.lf == newItem.lf
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
        holder.onBind(currentList[position], searchDetails)
    }

}

//class SearchScreenAdapter(private val openDetails: (String) -> Unit) :
//    ListAdapter<AcronymLongforms, SearchScreenAdapter.LongformViewHolder> {
//    class LongformViewHolder(private val binding: LongformsDisplayBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun onBinding(dataItem: AcronymLongforms, openData: (AcronymLongforms) -> Unit) {
//            binding.Llongform.text = dataItem.lf
//            binding.Lfrequency.text = dataItem.freq
//            binding.Lsince.text = dataItem.since
//            binding.root.setOnClickListener { openData(dataItem) }
//        }
//    }
//}
//
//override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
//    SearchScreenAdapter.LongformViewHolder(
//        LongformsDisplayBinding.inflate(
//            LayoutInflater.from(parent.context),
//            parent,
//            false
//        )
//    )
//
//override fun onBindViewHolder(holder: SearchScreenAdapter.LongformViewHolder, position: Int) {
//    holder.onBinding(dataset[position], openDetails)
//}
//
//fun updateList(response: List<AcronymLongforms>) {
//    dataset = response
//}
//
//override fun getItemCount(): Int {
//    return dataset.size
//}