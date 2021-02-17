package com.example.movieapp.di

import com.example.movieapp.network.MovieRetrofitService
import com.example.movieapp.network.model.MovieDtoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideMovieMapper(): MovieDtoMapper {
        return MovieDtoMapper()
    }

    @Singleton
    @Provides
    fun provideMovieService(): MovieRetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(MovieRetrofitService::class.java)
    }

    @Singleton
    @Provides
    @Named("api_key")
    fun provideApiKey(): String {
        return "555dd34b51d2f5b7f9fdb39e04986933"
    }
}