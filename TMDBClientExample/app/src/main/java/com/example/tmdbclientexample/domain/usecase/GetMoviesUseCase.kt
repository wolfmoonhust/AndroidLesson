package com.example.tmdbclientexample.domain.usecase

import com.example.tmdbclientexample.domain.repository.MovieRepository
import com.example.tmdbclientexample.data.model.movie.Movie

class GetMoviesUseCase (private val movieRepository: MovieRepository){

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()

}