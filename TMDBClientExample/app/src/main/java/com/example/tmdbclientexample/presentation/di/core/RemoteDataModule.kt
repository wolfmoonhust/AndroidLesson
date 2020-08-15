package com.example.tmdbclientexample.presentation.di.core

import com.example.tmdbclientexample.data.api.TMDBservice
import com.example.tmdbclientexample.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.tmdbclientexample.data.repository.artist.datasource.TvShowRemoteDatasource
import com.example.tmdbclientexample.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import com.example.tmdbclientexample.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmdbclientexample.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import com.example.tmdbclientexample.data.repository.tvshow.datasourceImpl.TvShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdBservice: TMDBservice): MovieRemoteDatasource {
        return MovieRemoteDatasourceImpl(tmdBservice, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdBservice: TMDBservice): TvShowRemoteDatasource {
        return TvShowRemoteDatasourceImpl(tmdBservice, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdBservice: TMDBservice): ArtistRemoteDatasource {
        return ArtistRemoteDatasourceImpl(tmdBservice, apiKey)
    }
}