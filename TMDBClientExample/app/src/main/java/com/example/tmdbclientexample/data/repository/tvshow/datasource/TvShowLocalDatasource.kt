package com.example.tmdbclientexample.data.repository.artist.datasource

import com.example.tmdbclientexample.data.model.artist.Artist
import com.example.tmdbclientexample.data.model.tvshow.TvShow

interface TvShowLocalDatasource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(artists: List<TvShow>)
    suspend fun clearAll()
}