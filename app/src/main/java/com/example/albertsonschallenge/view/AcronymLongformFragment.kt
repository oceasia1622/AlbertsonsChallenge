package com.example.albertsonschallenge.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.albertsonschallenge.databinding.SearchResultsBinding
import com.example.albertsonschallenge.model.UIState
import com.example.albertsonschallenge.model.remote.Vars
import com.example.albertsonschallenge.view.adapters.SearchScreenAdapter
import com.example.albertsonschallenge.viewmodel.AcronymSearchScreenViewModel
import com.google.android.material.snackbar.Snackbar

class AcronymLongformFragment: Fragment() {

    private lateinit var binding: SearchResultsBinding
    private lateinit var screenAdapter: SearchScreenAdapter

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

        initViews()
        initObservables()

        return binding.root
    }

    private fun initObservables() {
        viewModel.searchState.observe(viewLifecycleOwner) {
            when(it) {
                is UIState.Error -> {
                    showError(it.errorMessage)
                }
                is UIState.Response -> {
                    binding.rvlfs.adapter = screenAdapter
                    binding.rvlfs.layoutManager = LinearLayoutManager(context)
                    screenAdapter.updateList(it.success[0].lfs)
                }
                else -> { }
            }
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
        screenAdapter = SearchScreenAdapter(searchDetails = ::searchDetails)
    }

    private fun showError(errorMessage: String) {
        Snackbar.make(
            binding.root,
            errorMessage,
            Snackbar.LENGTH_INDEFINITE
        ).setAction("Dismiss") {}.show()
    }

    private fun searchDetails(vars: List<Vars>) {
        val displayVarsNames = vars.map { it.lf }
        Toast.makeText(
            context,
            "Variations\n${displayVarsNames.joinToString("\n")}",
            Toast.LENGTH_LONG).show()
    }
}