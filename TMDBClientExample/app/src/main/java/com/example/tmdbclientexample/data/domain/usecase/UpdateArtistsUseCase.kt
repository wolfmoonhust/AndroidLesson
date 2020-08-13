package com.example.tmdbclientexample.data.domain.usecase

import com.example.tmdbclientexample.data.domain.repository.ArtistRepository
import com.example.tmdbclientexample.data.model.artist.Artist

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}