package com.example.tmdbclientexample.presentation.di

import com.example.tmdbclientexample.data.model.tvshow.TvShow
import com.example.tmdbclientexample.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclientexample.presentation.di.movie.MovieSubComponent
import com.example.tmdbclientexample.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}