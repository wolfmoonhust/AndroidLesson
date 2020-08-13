package com.example.tmdbclientexample.data.domain.repository

import com.example.tmdbclientexample.data.model.movie.Movie
import com.example.tmdbclientexample.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows(): List<TvShow>?
}