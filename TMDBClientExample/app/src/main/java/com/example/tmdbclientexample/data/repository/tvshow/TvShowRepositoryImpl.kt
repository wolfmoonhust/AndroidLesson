package com.example.tmdbclientexample.data.repository.tvshow

import android.util.Log
import com.example.tmdbclientexample.domain.repository.TvShowRepository
import com.example.tmdbclientexample.data.model.tvshow.TvShow
import com.example.tmdbclientexample.data.repository.artist.datasource.TvShowCacheDatasource
import com.example.tmdbclientexample.data.repository.artist.datasource.TvShowLocalDatasource
import com.example.tmdbclientexample.data.repository.artist.datasource.TvShowRemoteDatasource

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowCacheDatasource: TvShowCacheDatasource,
    private val tvShowLocalDatasource: TvShowLocalDatasource
) : TvShowRepository {


    override suspend fun getTvShows(): List<TvShow>? {
        return  getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDatasource.saveTvShowsToCache(newListOfTvShows)
        return  newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>

        try {
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowsList = body.tvShows
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        return tvShowsList
    }

    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>

        try {
            tvShowsList = tvShowLocalDatasource.getTvShowsFromDB()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (tvShowsList.isNotEmpty()) {
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromAPI()
            tvShowLocalDatasource.saveTvShowsToDB(tvShowsList)
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var tvShowsList: List<TvShow>

        try {
            tvShowsList = tvShowCacheDatasource.getTvShowsFromCache()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (tvShowsList.isNotEmpty()) {
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromDB()
            tvShowCacheDatasource.saveTvShowsToCache(tvShowsList)
        }

        return tvShowsList
    }



}