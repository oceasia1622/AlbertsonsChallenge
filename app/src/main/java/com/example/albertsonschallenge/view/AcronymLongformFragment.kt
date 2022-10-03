package com.example.albertsonschallenge.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.albertsonschallenge.databinding.SearchResultsBinding
import com.example.albertsonschallenge.model.remote.AcronymLongforms
import com.example.albertsonschallenge.model.remote.Acronyms
import com.example.albertsonschallenge.view.adapters.SearchScreenAdapter
import com.example.albertsonschallenge.viewmodel.AcronymSearchScreenViewModel

class AcronymLongformFragment: Fragment() {
    private lateinit var binding: SearchResultsBinding
    private lateinit var adapter: SearchScreenAdapter

    private val viewModel: AcronymSearchScreenViewModel by lazy{
        ViewModelProvider(this)[AcronymSearchScreenViewModel::class.java]
    }

    companion object{
        private const val KEY_LIST: String = "List_Acronym_Longforms"
        fun newInstance(data: List<Acronyms>) =
            AcronymLongformFragment().apply {
                arguments = Bundle().apply {
                    val result = ArrayList<Acronyms>()
                    data.forEach { result.add(it) }
                    putParcelableArrayList(KEY_LIST, result)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = SearchResultsBinding.inflate(
            inflater,
            container,
            false
        )

        initObservables()
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.acronymSearch.setOnQueryTextListener(
            object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean{
                    return query?.let {
                        viewModel.searchAcronyms(it)
                        true
                    } ?: false
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            }
        )
        adapter = SearchScreenAdapter(emptyList()){
            updateAdapter(it as List<AcronymLongforms>)
        }
        binding.rvlfs.adapter = adapter
        binding.rvlfs.layoutManager = LinearLayoutManager(context)
    }

    private fun initObservables() {
        viewModel.uiState.observe(viewLifecycleOwner, Observer {
            updateAdapter(it)
        })
    }

    private fun updateAdapter(dataSet: List<AcronymLongforms>) {
        adapter.updateList(dataSet)
    }
}