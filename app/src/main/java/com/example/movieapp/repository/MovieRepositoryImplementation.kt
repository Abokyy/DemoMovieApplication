package com.example.movieapp.repository

import com.example.movieapp.domain.model.Movie
import com.example.movieapp.network.MovieRetrofitService
import com.example.movieapp.network.model.MovieDtoMapper

class MovieRepositoryImplementation(
    private val movieService: MovieRetrofitService,
    private val movieDtoMapper: MovieDtoMapper
) : MovieRepository {

    override suspend fun getPopularMovies(key: String): List<Movie> {
        return movieDtoMapper.toDomainList(movieService.getPopularMovies(key).popularMovies)
    }

    override suspend fun getMovieById(key: String, id: Int): Movie {
        return movieDtoMapper.mapToDomainModel(movieService.getMovie(id, key))
    }

    override suspend fun searchMovies(key: String, query: String): List<Movie> {
        return movieDtoMapper.toDomainList(movieService.searchMovies(key, query).searchedMovies)
    }

    override suspend fun discoverMoviesWithKeywords(key: String, keywordIds: String): List<Movie> {
        return movieDtoMapper.toDomainList(movieService.discoverMovies(key,keywordIds).searchedMovies)
    }


}