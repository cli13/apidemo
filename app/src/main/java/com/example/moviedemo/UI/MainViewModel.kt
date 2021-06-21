package com.example.moviedemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviedemo.data.repoistory.MainRepo
import com.example.moviedemo.data.response.MovieItem

class MainViewModel(private val repo: MainRepo) : ViewModel() {

    var currentPage = 1

    private var _list = MutableLiveData<List<MovieItem>>()
    val listResult: LiveData<List<MovieItem>>
        get() = _list

    private var _totalPage = MutableLiveData<Int>()
    val totalPage: LiveData<Int>
        get() = _totalPage

    fun getNowPlaying() {
        val data = repo.getNowPlayingMovies(currentPage.toString())
        _list.postValue(data.value!!.results)
        _totalPage.postValue(data.value!!.total_pages)
    }

}