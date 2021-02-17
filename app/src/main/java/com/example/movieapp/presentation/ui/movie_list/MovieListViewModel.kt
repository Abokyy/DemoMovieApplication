package com.example.movieapp.presentation.ui.movie_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MovieListViewModel
@Inject
constructor(
    private val repository: MovieRepository,
    @Named("api_key") private val api_key: String,
) : ViewModel() {

    val movies: MutableState<List<Movie>> = mutableStateOf(listOf())

    val query = mutableStateOf("")

    val noMoviesFound = mutableStateOf(false)

    val loading = mutableStateOf(false)

    init {
        getPopularMoviesWithBudgets()
    }

    fun searchMovies() {
        viewModelScope.launch {
            movies.value = listOf()
            loading.value = true
            delay(1000)
            val result = repository.searchMovies(
                api_key,
                query.value
            )

            if (result.isNotEmpty()){
                noMoviesFound.value = false
                movies.value = result
            } else {
                noMoviesFound.value = true
            }

            loading.value = false
        }
    }

    fun getPopularMoviesWithBudgets() {
        viewModelScope.launch {
            loading.value = true
            delay(1000)
            val popularMoviesResult = repository.getPopularMovies(
                api_key
            )

            val deferreds: List<Deferred<Movie>> = popularMoviesResult.map { movie ->
                async {
                    repository.getMovieById(api_key, movie.id)
                }
            }
            movies.value = deferreds.awaitAll()
            loading.value = false
        }
    }


    fun onQueryChanged(query: String) {
        this.query.value = query
    }
}