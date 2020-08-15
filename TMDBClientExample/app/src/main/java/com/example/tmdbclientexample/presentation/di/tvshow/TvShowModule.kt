package com.example.tmdbclientexample.presentation.di.tvshow

import com.example.tmdbclientexample.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclientexample.domain.usecase.UpdateTvShowsUseCase
import com.example.tmdbclientexample.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }

}