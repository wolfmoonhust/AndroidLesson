package com.example.tmdbclientexample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbclientexample.data.db.ArtistDao
import com.example.tmdbclientexample.data.db.MovieDao
import com.example.tmdbclientexample.data.db.TvShowDao
import com.example.tmdbclientexample.data.model.artist.Artist
import com.example.tmdbclientexample.data.model.movie.Movie
import com.example.tmdbclientexample.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabases : RoomDatabase() {
    abstract fun  movieDao() : MovieDao
    abstract fun tvDao() : TvShowDao
    abstract fun artistDao(): ArtistDao

}