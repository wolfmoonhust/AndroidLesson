package com.example.tmdbclientexample.presentation.di.tvshow

import com.example.tmdbclientexample.presentation.artist.ArtistActivity
import com.example.tmdbclientexample.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}