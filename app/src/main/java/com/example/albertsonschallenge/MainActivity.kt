package com.example.albertsonschallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.albertsonschallenge.databinding.ActivityMainBinding
import com.example.albertsonschallenge.model.remote.Acronyms
import com.example.albertsonschallenge.view.AcronymSearchDisplay
import com.example.albertsonschallenge.viewmodel.AcronymSearchScreenViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
//    @Inject lateinit var viewModel: AcronymSearchScreenViewModel
    private lateinit var viewModel: AcronymSearchScreenViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
//        ACApplication.component.inject(this)

//        viewModel.uiState.observe(this) {
//            when(it){
//                is UIState.Response -> initFragment(it.success)
//                is UIState.Error -> showError(it.errorMessage)
//                is UIState.Loading -> showLoading(it.isloading)
//                is UIState.Empty-> refreshData()
//                else -> {}
//            }
//        }
    }
    private fun refreshData() {
        TODO("Not yet implemented")
    }

    private fun showLoading(loading: Boolean) {
        binding.progressBar.visibility = if (loading) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
    }


    private fun showError(errorMessage: String) {
        Snackbar.make(
            binding.content,
            errorMessage,
            Snackbar.LENGTH_INDEFINITE
        ).setAction("Dismiss"){
            Toast.makeText(this@MainActivity,
                "Dismiss Toast",
                Toast.LENGTH_SHORT).show()
        }
            .show()
    }

    private fun initFragment(data: List<Acronyms>) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, AcronymSearchDisplay.newInstance(data))
            .commit()
    }
}