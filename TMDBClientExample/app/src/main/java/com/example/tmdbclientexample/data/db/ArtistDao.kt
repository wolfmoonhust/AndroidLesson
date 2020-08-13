package com.example.tmdbclientexample.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclientexample.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(Artists: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists(): List<Artist>
}