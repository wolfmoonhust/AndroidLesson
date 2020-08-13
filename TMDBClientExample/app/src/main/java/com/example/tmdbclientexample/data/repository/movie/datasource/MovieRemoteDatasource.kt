package com.example.tmdbclientexample.data.repository.movie.datasource

import com.example.tmdbclientexample.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {

    suspend fun getMovies(): Response<MovieList>
}