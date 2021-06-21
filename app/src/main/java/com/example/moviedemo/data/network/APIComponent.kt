package com.example.moviedemo.data.network

import com.example.moviedemo.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [MovieAPIClient::class])
@Singleton
interface APIComponent {
    fun injectMovieAPIServices(activity: MainActivity)
}