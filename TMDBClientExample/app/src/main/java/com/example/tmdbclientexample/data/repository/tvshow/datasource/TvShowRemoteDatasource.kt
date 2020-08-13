package com.example.tmdbclientexample.data.repository.artist.datasource

import com.example.tmdbclientexample.data.model.artist.ArtistList
import com.example.tmdbclientexample.data.model.movie.MovieList
import com.example.tmdbclientexample.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows(): Response<TvShowList>
}