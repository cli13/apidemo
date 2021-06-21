package com.example.moviedemo.data.network

import com.example.moviedemo.data.response.NowPlayingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPIServices {
    @GET("movie/now_playing?api_key=${MovieAPIClient.API_KEY}&language=en-US")
    suspend fun getNowPlaying(@Query("page") page: String): Response<NowPlayingResponse>
}