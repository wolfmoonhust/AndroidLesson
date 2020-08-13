package com.example.tmdbclientexample.data.repository.artist.datasource

import com.example.tmdbclientexample.data.model.artist.ArtistList
import com.example.tmdbclientexample.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists(): Response<ArtistList>
}