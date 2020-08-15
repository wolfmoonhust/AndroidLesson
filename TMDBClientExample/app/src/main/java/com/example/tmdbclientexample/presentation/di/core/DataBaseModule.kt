package com.example.tmdbclientexample.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdbclientexample.data.db.ArtistDao
import com.example.tmdbclientexample.data.db.MovieDao
import com.example.tmdbclientexample.data.db.TMDBDatabases
import com.example.tmdbclientexample.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabases {
        return Room.databaseBuilder(context,TMDBDatabases::class.java, "tmdbclient" ).build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabases: TMDBDatabases): MovieDao {
        return tmdbDatabases.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabases: TMDBDatabases): TvShowDao {
        return tmdbDatabases.tvDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabases: TMDBDatabases): ArtistDao {
        return tmdbDatabases.artistDao()
    }

}