package com.example.movieapp.di

import com.example.movieapp.network.MovieRetrofitService
import com.example.movieapp.network.model.MovieDtoMapper
import com.example.movieapp.repository.MovieRepository
import com.example.movieapp.repository.MovieRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieService: MovieRetrofitService,
        movieDtoMapper: MovieDtoMapper
    ): MovieRepository {
        return  MovieRepositoryImplementation(movieService, movieDtoMapper)
    }
}