package com.example.movieapp.network.model

import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.util.DomainMapper

class MovieDtoMapper : DomainMapper<MovieDto, Movie> {

    override fun mapToDomainModel(model: MovieDto): Movie {
        return Movie(
            id = model.id,
            title = model.title,
            poster_path = model.poster_path,
            budget = model.budget,
            vote_average = model.vote_average
        )
    }

    override fun mapFromDomainModel(domainModel: Movie): MovieDto {
        return MovieDto(
            id = domainModel.id,
            title = domainModel.title,
            poster_path = domainModel.poster_path,
            budget = domainModel.budget,
            vote_average = domainModel.vote_average
        )
    }

    fun toDomainList(initial: List<MovieDto>): List<Movie> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Movie>): List<MovieDto> {
        return initial.map { mapFromDomainModel(it) }
    }

}