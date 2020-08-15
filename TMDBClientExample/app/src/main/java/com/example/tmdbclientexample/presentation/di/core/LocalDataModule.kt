package com.example.tmdbclientexample.presentation.di.core

import com.example.tmdbclientexample.data.db.ArtistDao
import com.example.tmdbclientexample.data.db.MovieDao
import com.example.tmdbclientexample.data.db.TvShowDao
import com.example.tmdbclientexample.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.tmdbclientexample.data.repository.artist.datasource.TvShowLocalDatasource
import com.example.tmdbclientexample.data.repository.artist.datasourceImpl.ArtistLocalDatasourceImpl
import com.example.tmdbclientexample.data.repository.movie.datasource.MovieLocalDatasource
import com.example.tmdbclientexample.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import com.example.tmdbclientexample.data.repository.tvshow.datasourceImpl.TvShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movideDao: MovieDao): MovieLocalDatasource {
        return MovieLocalDatasourceImpl(movideDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDatasource {
        return TvShowLocalDatasourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDatasource {
        return ArtistLocalDatasourceImpl(artistDao)
    }
}