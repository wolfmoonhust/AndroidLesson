package com.example.tmdbclientexample.data.repository.artist.datasource

import com.example.tmdbclientexample.data.model.artist.Artist

interface ArtistCacheDatasource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}