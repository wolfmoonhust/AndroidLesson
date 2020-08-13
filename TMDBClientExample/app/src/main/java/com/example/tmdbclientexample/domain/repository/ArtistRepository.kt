package com.example.tmdbclientexample.domain.repository

import com.example.tmdbclientexample.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists(): List<Artist>?
}