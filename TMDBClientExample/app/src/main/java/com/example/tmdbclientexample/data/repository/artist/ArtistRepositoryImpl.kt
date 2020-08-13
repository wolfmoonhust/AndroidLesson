package com.example.tmdbclientexample.data.repository.artist

import android.util.Log
import com.example.tmdbclientexample.domain.repository.ArtistRepository
import com.example.tmdbclientexample.data.model.artist.Artist
import com.example.tmdbclientexample.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.tmdbclientexample.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.tmdbclientexample.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.tmdbclientexample.data.repository.artist.datasource.TvShowRemoteDatasource

class ArtistRepositoryImpl(
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource
): ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }



    override suspend fun updateArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }

    suspend fun getArtistsFromAPI(): List<Artist>{
        lateinit var artistsList: List<Artist>

        try {
            val response = artistRemoteDatasource.getArtists()
            val body =  response.body()

            if ( body != null){
                artistsList = body.artists
            }

        } catch (exception: Exception){
            Log.i("MYTAG", exception.message.toString())
        }
        return artistsList
    }

    suspend fun getArtistsFromDB(): List<Artist>{
        lateinit var artistsList: List<Artist>

        try {
            artistsList = artistLocalDatasource.getArtistsFromDB()
        }catch (exception: Exception){
            Log.i("MYTAG", exception.message.toString())
        }

        if(artistsList.isNotEmpty()){
            return artistsList
        } else {
            artistsList = getArtistsFromAPI()
            artistLocalDatasource.saveArtistsToDB(artistsList)
        }

        return  artistsList
    }

    suspend fun getArtistFromCache(): List<Artist>? {
        lateinit var artistsList: List<Artist>

        try {
            artistsList = artistCacheDatasource.getArtistsFromCache()
        }catch (exception: Exception){
            Log.i("MYTAG", exception.message.toString())
        }

        if(artistsList.isNotEmpty()){
            return artistsList
        } else {
            artistsList = getArtistsFromDB()
            artistCacheDatasource.saveArtistsToCache(artistsList)
        }

        return  artistsList
    }

}