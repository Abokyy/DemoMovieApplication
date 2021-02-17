package com.example.movieapp.presentation.ui.movie

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MovieDetailViewModel
@Inject
constructor(
    private val repository: MovieRepository,
    @Named("api_key") private val api_key: String,
) : ViewModel() {

    val movie : MutableState<Movie?> = mutableStateOf(null)


    fun getMovieById(id: Int){
        viewModelScope.launch {
            val result = repository.getMovieById(api_key, id)

            movie.value = result
        }
    }
}
