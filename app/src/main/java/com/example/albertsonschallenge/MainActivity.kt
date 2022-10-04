package com.example.albertsonschallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.albertsonschallenge.databinding.ActivityMainBinding
import com.example.albertsonschallenge.model.UIState
import com.example.albertsonschallenge.model.remote.AcronymItem
import com.example.albertsonschallenge.view.AcronymLongformFragment
import com.example.albertsonschallenge.viewmodel.AcronymSearchScreenViewModel
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var viewModel: AcronymSearchScreenViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.searchResult.observe(this) {
            when (it) {
                is UIState.Response -> initFragment(it.success)
                is UIState.Error -> showError(it.errorMessage)
                is UIState.Loading -> showLoading(it.loading)
                is UIState.Empty -> refreshData()
            }
        }
    }

    private fun showError(errorMessage: String) {
        Snackbar.make(
            binding.content,
            errorMessage,
            Snackbar.LENGTH_INDEFINITE

        ).setAction("Dismiss") {
            Toast.makeText(
                this@MainActivity,
                "Dismiss Toast",
                Toast.LENGTH_SHORT
            ).show()
        }
            .show()
    }

    private fun initFragment(data: List<AcronymItem>) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, AcronymLongformFragment())
            .commit()

    }

    //TODO
    private fun refreshData() {
    }

    private fun showLoading(loading: Boolean) {
//        binding.progressBar.visibility = if (loading) {
//            View.VISIBLE
//        } else {
//            View.INVISIBLE
//        }
    }

}