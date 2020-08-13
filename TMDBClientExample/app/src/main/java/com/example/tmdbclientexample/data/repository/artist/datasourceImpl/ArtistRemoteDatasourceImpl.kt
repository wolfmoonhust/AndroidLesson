package com.example.tmdbclientexample.data.repository.artist.datasourceImpl

import com.example.tmdbclientexample.data.api.TMDBservice
import com.example.tmdbclientexample.data.model.artist.ArtistList
import com.example.tmdbclientexample.data.model.tvshow.TvShowList
import com.example.tmdbclientexample.data.repository.artist.datasource.TvShowRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val tmdbService: TMDBservice,
    private val apiKey: String
): TvShowRemoteDatasource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}