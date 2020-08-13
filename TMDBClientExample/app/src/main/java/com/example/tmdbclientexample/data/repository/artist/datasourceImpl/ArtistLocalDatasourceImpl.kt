package com.example.tmdbclientexample.data.repository.artist.datasourceImpl

import com.example.tmdbclientexample.data.db.ArtistDao
import com.example.tmdbclientexample.data.model.artist.Artist
import com.example.tmdbclientexample.data.repository.artist.datasource.ArtistLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDatasourceImpl(private val artistDao: ArtistDao) :
    ArtistLocalDatasource {

    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }

}