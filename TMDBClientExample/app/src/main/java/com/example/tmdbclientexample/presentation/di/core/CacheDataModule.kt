package com.example.tmdbclientexample.presentation.di.core

import com.example.tmdbclientexample.data.model.tvshow.TvShow
import com.example.tmdbclientexample.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.tmdbclientexample.data.repository.artist.datasource.TvShowCacheDatasource
import com.example.tmdbclientexample.data.repository.artist.datasourceImpl.ArtistCacheDatasourceImpl
import com.example.tmdbclientexample.data.repository.movie.datasource.MovieCacheDatasource
import com.example.tmdbclientexample.data.repository.movie.datasourceImpl.MovieCacheDatasourceImpl
import com.example.tmdbclientexample.data.repository.tvshow.datasourceImpl.TvShowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDatasource{
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDatasource {
        return TvShowCacheDatasourceImpl()
    }
    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDatasource {
        return ArtistCacheDatasourceImpl()
    }
}