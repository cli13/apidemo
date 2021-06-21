package com.example.moviedemo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviedemo.data.repoistory.MainRepo
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val mainRepo: MainRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(mainRepo) as T
    }

}