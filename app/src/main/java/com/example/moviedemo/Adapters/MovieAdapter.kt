package com.example.moviedemo.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedemo.data.network.MovieAPIClient
import com.example.moviedemo.data.response.MovieItem
import com.example.moviedemo.databinding.MovieItemBinding
import com.squareup.picasso.Picasso

class MovieAdapter(var list: List<MovieItem>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movieItem: MovieItem) {
            binding.movieItem = movieItem
            Picasso.get().load(MovieAPIClient.IMAGE_URL + movieItem.poster_path).into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieItem = list[position]
        holder.bind(movieItem)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}