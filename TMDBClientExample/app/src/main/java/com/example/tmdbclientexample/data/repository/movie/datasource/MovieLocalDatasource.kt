package com.example.tmdbclientexample.data.repository.movie.datasource

import com.example.tmdbclientexample.data.model.movie.Movie

interface MovieLocalDatasource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}