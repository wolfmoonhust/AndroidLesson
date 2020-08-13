package com.example.tmdbclientexample.data.domain.repository

import com.example.tmdbclientexample.data.model.artist.Artist
import com.example.tmdbclientexample.data.model.movie.Movie

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists(): List<Artist>?
}