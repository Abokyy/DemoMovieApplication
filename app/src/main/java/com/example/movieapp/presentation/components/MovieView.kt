package com.example.movieapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.utils.formatBudget
import com.example.movieapp.utils.loadPicture

@Composable
fun MovieView(
    movie: Movie?
) {
    ScrollableColumn  {
        if (movie != null) {
            movie.poster_path?.let { url ->
                val image =
                    loadPicture(url = url, defaultImage = DEFAULT_MOVIE_IMG).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .preferredHeight(420.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    text = movie.title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.h4
                )
                Text(
                    text = formatBudget(movie.budget),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = "Vote average: ${movie.vote_average}",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.h5
                )
            }
        } else {
            Text(
                text = "Something went wrong",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.h4
            )
        }
    }
}