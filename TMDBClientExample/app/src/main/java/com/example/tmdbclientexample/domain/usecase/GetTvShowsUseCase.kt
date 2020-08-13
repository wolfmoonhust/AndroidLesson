package com.example.tmdbclientexample.domain.usecase

import com.example.tmdbclientexample.domain.repository.TvShowRepository
import com.example.tmdbclientexample.data.model.tvshow.TvShow

class GetTvShowsUseCase (private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? =  tvShowRepository.getTvShows()
}