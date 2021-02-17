package com.example.movieapp.network.model

import com.google.gson.annotations.SerializedName

data class MovieDto (
    @SerializedName("id")
    var id : Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("poster_path")
    var poster_path: String? = null,

    @SerializedName("budget")
    var budget: Int,

    @SerializedName("vote_average")
    var vote_average: Double
)