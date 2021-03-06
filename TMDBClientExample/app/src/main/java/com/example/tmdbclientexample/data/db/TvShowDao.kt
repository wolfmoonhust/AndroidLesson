package com.example.tmdbclientexample.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclientexample.data.model.tvshow.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShow: List<TvShow>)

    @Query("DELETE FROM popular_tvshows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tvshows")
    suspend fun getTvshows(): List<TvShow>
}