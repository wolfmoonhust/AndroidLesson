package com.example.tmdbclientexample.data.domain.usecase

import com.example.tmdbclientexample.data.domain.repository.MovieRepository
import com.example.tmdbclientexample.data.model.movie.Movie

class GetMoviesUseCase (private val movieRepository: MovieRepository){

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()

}