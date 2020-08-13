package com.example.tmdbclientexample.data.repository.movie

import android.util.Log
import com.example.tmdbclientexample.data.domain.repository.MovieRepository
import com.example.tmdbclientexample.data.model.movie.Movie
import com.example.tmdbclientexample.data.repository.movie.datasource.MovieCacheDatasource
import com.example.tmdbclientexample.data.repository.movie.datasource.MovieLocalDatasource
import com.example.tmdbclientexample.data.repository.movie.datasource.MovieRemoteDatasource

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieCacheDatasource: MovieCacheDatasource,
    private val movieLocalDatasource: MovieLocalDatasource
) : MovieRepository {


    override suspend fun getMovies(): List<Movie>? {
        return  getMovieFromCache()
    }

    override suspend fun updateMovie(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newListOfMovies)
        movieCacheDatasource.saveMoviesToCache(newListOfMovies)
        return  newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var moviesList: List<Movie>

        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if (body != null) {
                moviesList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        return moviesList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var moviesList: List<Movie>

        try {
            moviesList = movieLocalDatasource.getMoviesFromDB()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (moviesList.isNotEmpty()) {
            return moviesList
        } else {
            moviesList = getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToDB(moviesList)
        }
        return moviesList
    }

    suspend fun getMovieFromCache(): List<Movie>{
        lateinit var moviesList: List<Movie>

        try {
            moviesList = movieCacheDatasource.getMoviesFromCache()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (moviesList.isNotEmpty()) {
            return moviesList
        } else {
            moviesList = getMoviesFromDB()
            movieCacheDatasource.saveMoviesToCache(moviesList)
        }

        return moviesList
    }



}