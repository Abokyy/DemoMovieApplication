package com.example.movieapp.network.responses

import com.example.movieapp.network.model.MovieDto
import com.google.gson.annotations.SerializedName

data class SearchMoviesResponse(
    @SerializedName("total_results")
    var count: Int,

    @SerializedName("results")
    var searchedMovies: List<MovieDto>
)