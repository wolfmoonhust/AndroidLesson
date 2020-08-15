package com.example.tmdbclientexample.presentation.di.movie

import com.example.tmdbclientexample.presentation.artist.ArtistActivity
import com.example.tmdbclientexample.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }
}