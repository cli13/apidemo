package com.example.moviedemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviedemo.data.repoistory.MainRepo
import com.example.moviedemo.data.response.MovieItem
import com.example.moviedemo.data.response.NowPlayingResponse

class MainViewModel(private val repo: MainRepo) : ViewModel() {

    private var currentPage = 1

//    private var _list = MutableLiveData<List<MovieItem>>()
//    val listResult: LiveData<List<MovieItem>>
//        get() = _list
//
//    private var _totalPage = MutableLiveData<Int>()
//    val totalPage: LiveData<Int>
//        get() = _totalPage

//    val response: LiveData<NowPlayingResponse?>
//        get() = repo.getNowPlayingMovies(currentPage.toString())

    fun getNowPlaying() : LiveData<NowPlayingResponse?> {
        return repo.getNowPlayingMovies(currentPage.toString())
    }

    fun increasePage() {
        currentPage++
        getNowPlaying()
    }

}