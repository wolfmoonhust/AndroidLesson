package com.example.tmdbclientexample.data.repository.tvshow.datasourceImpl

import com.example.tmdbclientexample.data.model.movie.Movie
import com.example.tmdbclientexample.data.model.tvshow.TvShow
import com.example.tmdbclientexample.data.repository.artist.datasource.TvShowCacheDatasource
import com.example.tmdbclientexample.data.repository.movie.datasource.MovieCacheDatasource

class TvShowCacheDatasourceImpl :
    TvShowCacheDatasource {
    private var tvShowList =  ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList =  ArrayList(tvShows)

    }

}