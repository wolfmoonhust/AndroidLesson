package com.example.tmdbclientexample.data.domain.repository

import com.example.tmdbclientexample.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovie(): List<Movie>?
}