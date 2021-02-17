package com.example.movieapp.network.responses

import com.example.movieapp.network.model.MovieDto
import com.google.gson.annotations.SerializedName

data class MoviesPopularResponse (
    @SerializedName("total_results")
    var total_results: Int,

    @SerializedName("results")
    var popularMovies: List<MovieDto>
)