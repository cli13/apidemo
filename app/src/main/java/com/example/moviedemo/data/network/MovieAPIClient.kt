package com.example.moviedemo.data.network

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class MovieAPIClient {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/movie/"
        const val API_KEY = "35ddd0f68daf34c7e82522b910cc92ac"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    }

    @Provides
    @Singleton
    fun providesMovieClient(): MovieAPIServices {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPIServices::class.java)
    }
}