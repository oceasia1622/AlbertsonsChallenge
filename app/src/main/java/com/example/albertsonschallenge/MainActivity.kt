package com.example.albertsonschallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.albertsonschallenge.databinding.ActivityMainBinding
import com.example.albertsonschallenge.model.UIState
import com.example.albertsonschallenge.model.remote.AcronymItem
import com.example.albertsonschallenge.view.AcronymLongformFragment
import com.example.albertsonschallenge.viewmodel.AcronymSearchScreenViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, AcronymLongformFragment())
            .commit()
    }
}