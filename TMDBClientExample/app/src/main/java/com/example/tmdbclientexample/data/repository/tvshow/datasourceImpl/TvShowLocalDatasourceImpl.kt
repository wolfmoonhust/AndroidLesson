package com.example.tmdbclientexample.data.repository.tvshow.datasourceImpl

import com.example.tmdbclientexample.data.db.MovieDao
import com.example.tmdbclientexample.data.db.TvShowDao
import com.example.tmdbclientexample.data.model.movie.Movie
import com.example.tmdbclientexample.data.model.tvshow.TvShow
import com.example.tmdbclientexample.data.repository.artist.datasource.TvShowLocalDatasource
import com.example.tmdbclientexample.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDatasourceImpl (private val tvShowDao: TvShowDao):
    TvShowLocalDatasource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvshows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
       CoroutineScope(Dispatchers.IO).launch{
           tvShowDao.saveTvShows(tvShows)
       }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}