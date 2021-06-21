package com.example.moviedemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.moviedemo.R
import com.example.moviedemo.adapters.MovieAdapter
import com.example.moviedemo.data.network.DaggerAPIComponent
import com.example.moviedemo.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var factory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        DaggerAPIComponent.create().injectMovieAPIServices(this)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java).also {
            binding.viewModel = it
        }

        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.getNowPlaying()
        viewModel.listResult.observe(this) {
            binding.recyclerView.adapter = MovieAdapter(it)
        }
    }
}