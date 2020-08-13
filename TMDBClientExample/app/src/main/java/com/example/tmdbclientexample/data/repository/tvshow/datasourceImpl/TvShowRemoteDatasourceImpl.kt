package com.example.tmdbclientexample.data.repository.tvshow.datasourceImpl

import com.example.tmdbclientexample.data.api.TMDBservice
import com.example.tmdbclientexample.data.model.movie.MovieList
import com.example.tmdbclientexample.data.model.tvshow.TvShow
import com.example.tmdbclientexample.data.model.tvshow.TvShowList
import com.example.tmdbclientexample.data.repository.artist.datasource.TvShowRemoteDatasource
import com.example.tmdbclientexample.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(
    private val tmdbService: TMDBservice,
    private val apiKey: String
) :
    TvShowRemoteDatasource {
    override suspend fun getArtists(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}