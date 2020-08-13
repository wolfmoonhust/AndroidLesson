package com.example.tmdbclientexample.data.model.movie

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_movies")
data class Movie(
    @PrimaryKey
    val id: Int,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String

)