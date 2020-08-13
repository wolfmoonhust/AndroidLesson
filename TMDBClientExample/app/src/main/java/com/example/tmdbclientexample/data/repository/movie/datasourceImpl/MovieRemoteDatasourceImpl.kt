package com.example.tmdbclientexample.data.repository.movie.datasourceImpl

import com.example.tmdbclientexample.data.api.TMDBservice
import com.example.tmdbclientexample.data.model.movie.MovieList
import com.example.tmdbclientexample.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val tmdbService: TMDBservice,
    private val apiKey: String
) :
    MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}