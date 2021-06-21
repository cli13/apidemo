package com.example.moviedemo.data.response

data class NowPlayingResponse(
    val dates: Dates,
    val page: Int,
    val results: List<MovieItem>,
    val total_pages: Int,
    val total_results: Int
)