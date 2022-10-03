package com.example.albertsonschallenge.view
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.albertsonschallenge.databinding.ActivityMainBinding
//import com.example.albertsonschallenge.model.remote.AcronymLongforms
//import com.example.albertsonschallenge.model.remote.Acronyms
//import com.example.albertsonschallenge.view.adapters.SearchScreenAdapter
//
//class AcronymSearchDisplay : Fragment() {
//    private lateinit var binding: ActivityMainBinding
//    private lateinit var adapter: SearchScreenAdapter
//    companion object{
//        private const val KEY_LIST: String = "List_Acronym_Longforms"
//        fun newInstance(data: List<Acronyms>) =
//            AcronymSearchDisplay().apply {
//                arguments = Bundle().apply {
//                    val result = ArrayList<Acronyms>()
//                    data.forEach { result.add(it) }
//                    putParcelableArrayList(KEY_LIST, result)
//                }
//            }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        super.onCreateView(inflater, container, savedInstanceState)
//        binding = ActivityMainBinding.inflate(
//            inflater,
//            container,
//            false
//        )
//        initViews()
//        return binding.root
//    }
//
//    private fun initViews() {
//        adapter = SearchScreenAdapter(emptyList()){
//            updateAdapter(it as List<AcronymLongforms>)
//        }
//        binding.rvlfs.layoutManager = LinearLayoutManager(context)
//        binding.rvlfs.adapter = adapter
//    }
//
//    private fun updateAdapter(dataSet: List<AcronymLongforms>) {
//        adapter.updateList(dataSet)
//    }
//}