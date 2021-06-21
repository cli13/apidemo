package com.example.moviedemo.data.repoistory

import androidx.lifecycle.liveData
import com.example.moviedemo.data.network.MovieAPIServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainRepo @Inject constructor(private val apiServices: MovieAPIServices) {
    fun getNowPlayingMovies(page: String) = GlobalScope.launch {
        val a = async { apiServices.getNowPlaying(page) }

    }


}