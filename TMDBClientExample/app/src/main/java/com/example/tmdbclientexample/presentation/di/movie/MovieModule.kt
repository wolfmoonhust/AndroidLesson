package com.example.tmdbclientexample.presentation.di.movie

import com.example.tmdbclientexample.domain.usecase.GetMoviesUseCase
import com.example.tmdbclientexample.domain.usecase.UpdateMoviesUseCase
import com.example.tmdbclientexample.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }

}