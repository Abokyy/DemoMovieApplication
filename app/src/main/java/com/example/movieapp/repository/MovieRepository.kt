package com.example.movieapp.repository

import com.example.movieapp.domain.model.Movie

interface MovieRepository {

    suspend fun getPopularMovies(key: String): List<Movie>

    suspend fun getMovieById(key: String, id: Int): Movie

    suspend fun searchMovies(key: String, query: String): List<Movie>

    suspend fun discoverMoviesWithKeywords(key: String, keywordIds: String): List<Movie>
}