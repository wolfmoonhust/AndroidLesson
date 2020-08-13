package com.example.tmdbclientexample.data.repository.movie.datasource

import com.example.tmdbclientexample.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}