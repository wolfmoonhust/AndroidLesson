package com.example.tmdbclientexample.domain.usecase

import com.example.tmdbclientexample.domain.repository.ArtistRepository
import com.example.tmdbclientexample.data.model.artist.Artist

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}