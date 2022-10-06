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
import com.example.albertsonschallenge.model.UIState
import com.example.albertsonschallenge.model.remote.AcronymItem
import com.example.albertsonschallenge.model.remote.SearchResponse
import com.example.albertsonschallenge.view.adapters.SearchScreenAdapter
import com.example.albertsonschallenge.viewmodel.AcronymSearchScreenViewModel

class AcronymLongformFragment: Fragment() {

    private lateinit var binding: SearchResultsBinding
    private lateinit var adapter: SearchScreenAdapter
    private lateinit var acronymItem: SearchResponse

    private val viewModel: AcronymSearchScreenViewModel by lazy{
        ViewModelProvider(requireActivity())[AcronymSearchScreenViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = SearchResultsBinding.inflate(
            layoutInflater
        )

        initObservables()
        initViews()

        return binding.root
    }

    private fun initObservables() {
        viewModel.searchResult.observe(viewLifecycleOwner) {

        }
    }

    private fun initViews() {
        binding.acronymSearch.setOnQueryTextListener(
            object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean{
                    return query?.let {
                        viewModel.searchAcronym(it)
                        true
                    } ?: false
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            }
        )
        adapter = SearchScreenAdapter(acronymItem, ::searchDetails)
        binding.rvlfs.adapter = adapter
        binding.rvlfs.layoutManager = LinearLayoutManager(context)
    }

    private fun updateAdapter(dataSet: SearchResponse?) {
        adapter.submitList(dataSet!![0].lfs)
    }

    private fun searchDetails(item: AcronymItem) {
        //todo
    }
}