package com.example.movieapp.network

import com.example.movieapp.network.model.MovieDto
import com.example.movieapp.network.responses.MoviesPopularResponse
import com.example.movieapp.network.responses.SearchMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieRetrofitService {

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") key: String
    ): MoviesPopularResponse

    @GET("/3/movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") movieId : Int,
        @Query("api_key") key: String
    ): MovieDto

    @GET("/3/search/movie")
    suspend fun searchMovies(
        @Query("api_key") key: String,
        @Query("query") query: String
    ): SearchMoviesResponse


    @GET("/3/discover/movie")
    suspend fun discoverMovies(
        @Query("api_key") key: String,
        @Query("with_keywords") keywordIds: String
    ): SearchMoviesResponse
}