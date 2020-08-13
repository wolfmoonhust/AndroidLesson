package com.example.tmdbclientexample.data.model.tvshow

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_tvshows")
data class TvShow(
    @PrimaryKey
    val first_air_date: String,
    val id: Int,
    val name: String,
    val overview: String,
    val poster_path: String

)