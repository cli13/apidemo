package com.example.moviedemo.data.repoistory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.moviedemo.data.network.MovieAPIServices
import com.example.moviedemo.data.response.MovieItem
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MainRepo @Inject constructor(private val apiServices: MovieAPIServices) {
    fun getNowPlayingMovies(page: String) = liveData(Dispatchers.IO) {
        var response = apiServices.getNowPlaying(page)
        if (response.isSuccessful) {
            emit(response.body())
        }
    }
}