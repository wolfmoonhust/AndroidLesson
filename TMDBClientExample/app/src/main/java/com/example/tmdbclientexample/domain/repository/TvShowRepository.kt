package com.example.tmdbclientexample.domain.repository

import com.example.tmdbclientexample.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows(): List<TvShow>?
}