package com.example.tmdbclientexample.data.model.tvshow

import com.example.tmdbclientexample.data.model.tvshow.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>
)