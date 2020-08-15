package com.example.tmdbclientexample.presentation.di.core

import com.example.tmdbclientexample.data.repository.artist.ArtistRepositoryImpl
import com.example.tmdbclientexample.data.repository.artist.datasource.*
import com.example.tmdbclientexample.data.repository.movie.MovieRepositoryImpl
import com.example.tmdbclientexample.data.repository.movie.datasource.MovieCacheDatasource
import com.example.tmdbclientexample.data.repository.movie.datasource.MovieLocalDatasource
import com.example.tmdbclientexample.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmdbclientexample.data.repository.tvshow.TvShowRepositoryImpl
import com.example.tmdbclientexample.domain.repository.ArtistRepository
import com.example.tmdbclientexample.domain.repository.MovieRepository
import com.example.tmdbclientexample.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieCacheDatasource,
            movieLocalDatasource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDatasource: TvShowLocalDatasource,
        tvShowCacheDatasource: TvShowCacheDatasource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDatasource, tvShowCacheDatasource, tvShowLocalDatasource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDatasource: ArtistLocalDatasource,
        artistCacheDatasource: ArtistCacheDatasource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistLocalDatasource, artistRemoteDatasource, artistCacheDatasource
        )
    }
}