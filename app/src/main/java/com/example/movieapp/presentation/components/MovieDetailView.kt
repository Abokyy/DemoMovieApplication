package com.example.movieapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.utils.formatBudget
import com.example.movieapp.utils.loadPicture
import java.nio.file.WatchEvent

const val IMG_HEIGHT = 260

@Composable
fun MovieDetailView(
    movie: Movie
) {
    ScrollableColumn(modifier = Modifier.fillMaxWidth()) {
        movie.poster_path?.let { url ->
            val image = loadPicture(url = url, defaultImage = DEFAULT_MOVIE_IMG).value
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .preferredHeight(IMG_HEIGHT.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = movie.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start),
                style = MaterialTheme.typography.h3
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
    }
}