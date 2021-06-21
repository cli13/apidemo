package com.example.moviedemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedemo.R
import com.example.moviedemo.adapters.MovieAdapter
import com.example.moviedemo.data.network.DaggerAPIComponent
import com.example.moviedemo.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var adapter: MovieAdapter

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
        adapter = MovieAdapter(emptyList()).also { binding.recyclerView.adapter = it }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        setUpObserver()
        setUpListener()
    }

    private fun setUpListener() {
        binding.buttonNext.setOnClickListener {
            viewModel.increasePage()
        }

        binding.buttonPrev.setOnClickListener {

        }
    }

    private fun setUpObserver() {
        viewModel.getNowPlaying().observe(this) {
            adapter.list = it!!.results
            adapter.notifyDataSetChanged()
        }
    }
}