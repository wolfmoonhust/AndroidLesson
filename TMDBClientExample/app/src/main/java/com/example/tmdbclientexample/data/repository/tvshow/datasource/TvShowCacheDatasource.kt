package com.example.tmdbclientexample.data.repository.artist.datasource

import com.example.tmdbclientexample.data.model.artist.Artist
import com.example.tmdbclientexample.data.model.tvshow.TvShow

interface TvShowCacheDatasource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(artists: List<TvShow>)
}