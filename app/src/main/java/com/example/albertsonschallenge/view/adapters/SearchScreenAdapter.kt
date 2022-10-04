package com.example.albertsonschallenge.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.albertsonschallenge.databinding.LongformsDisplayBinding
import com.example.albertsonschallenge.model.remote.test
import com.example.albertsonschallenge.model.remote.testItem

class SearchScreenAdapter(private var currentList: test, private var searchDetails: (testItem) -> Unit):
    ListAdapter<test, SearchScreenAdapter.LongformViewHolder>(LongformDiffUtil) {
    class LongformViewHolder(private val binding: LongformsDisplayBinding):
        RecyclerView.ViewHolder(binding.root){
        fun onBind(dataItem: testItem, openData: (testItem) -> Unit) {
            binding.Llongform.text = dataItem.lfs.first().lf
            binding.Lfrequency.text = dataItem.lfs.first().freq.toString()
            binding.Lsince.text = dataItem.lfs.first().since.toString()
            binding.root.setOnClickListener { openData(dataItem) }
        }
    }

    object LongformDiffUtil: DiffUtil.ItemCallback<test>(){
        override fun areItemsTheSame(oldItem: test, newItem: test): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: test, newItem: test): Boolean {
            return oldItem.first().lfs.first().lf == newItem.first().lfs.first().lf
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

    fun updateList(response: test){
        currentList = response
        notifyDataSetChanged()
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