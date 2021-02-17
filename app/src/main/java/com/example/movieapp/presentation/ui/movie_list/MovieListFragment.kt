package com.example.movieapp.presentation.ui.movie_list

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.movieapp.R
import com.example.movieapp.presentation.components.CircularIndeterminateProgressBar
import com.example.movieapp.presentation.components.MovieCard
import com.example.movieapp.presentation.components.SearchAppBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private val viewModel: MovieListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {

                val popularMovies = viewModel.movies.value

                val query = viewModel.query.value

                val noMoviesFound = viewModel.noMoviesFound.value

                val isLoading = viewModel.loading.value

                Column {

                    SearchAppBar(
                        query = query,
                        onQueryChanged = viewModel::onQueryChanged,
                        onExecuteSearch = viewModel::searchMovies,
                    )

                    Box(modifier = Modifier.fillMaxSize()) {
                        if (noMoviesFound) {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = "No movies found",
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally),
                                    style = MaterialTheme.typography.h6
                                )
                            }

                        }
                        LazyColumn {
                            itemsIndexed(
                                items = popularMovies
                            ) { index, movie ->
                                MovieCard(movie = movie, onClick = {
                                    val bundle = Bundle()
                                    bundle.putParcelable("movie", movie)
                                    findNavController().navigate(R.id.viewMovie, bundle)
                                })
                            }
                        }
                        CircularIndeterminateProgressBar(isDisplayed = isLoading)
                    }


                }
            }
        }
    }
}