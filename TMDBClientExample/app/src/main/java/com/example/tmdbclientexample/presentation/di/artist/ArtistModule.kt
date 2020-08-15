package com.example.tmdbclientexample.presentation.di.artist

import com.example.tmdbclientexample.domain.usecase.GetArtistsUseCase
import com.example.tmdbclientexample.domain.usecase.UpdateArtistsUseCase
import com.example.tmdbclientexample.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }

}