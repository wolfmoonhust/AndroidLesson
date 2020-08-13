package com.example.tmdbclientexample.data.model.movie

import com.example.tmdbclientexample.data.model.movie.Movie

data class MovieList(
    val page: Int,
    val movies: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)