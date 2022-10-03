package com.example.albertsonschallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.example.albertsonschallenge.databinding.ActivityMainBinding
import com.example.albertsonschallenge.view.AcronymLongformFragment
import com.example.albertsonschallenge.viewmodel.AcronymSearchScreenViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container,
                AcronymLongformFragment())
            .commit()
    }

//        viewModel.uiState.observe(this)
//        {
//            when (it) {
//                is UIState.Response -> initFragment(it.success)
//                is UIState.Error -> showError(it.errorMessage)
//                is UIState.Loading -> showLoading(it.loading)
//                is UIState.Empty -> refreshData()
//            }
//        }
//
//    }
//    private fun refreshData() {
//        TODO("Not yet implemented")
//    }
//
//    private fun showLoading(loading: Boolean) {
//        binding.progressBar.visibility = if (loading) {
//            View.VISIBLE
//        } else {
//            View.INVISIBLE
//        }
//    }
//
//    private fun showError(errorMessage: String) {
//        Snackbar.make(
//            binding.content,
//            errorMessage,
//            Snackbar.LENGTH_INDEFINITE
//        ).setAction("Dismiss"){
//            Toast.makeText(this@MainActivity,
//                "Dismiss Toast",
//                Toast.LENGTH_SHORT).show()
//        }
//            .show()
//    }
//
//    private fun initFragment(data: List<Acronyms>) {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.container, AcronymLongformFragment.newInstance(data))
//            .commit()
//    }
}