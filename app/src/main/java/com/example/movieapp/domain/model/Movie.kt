package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val poster_path: String? = null,
    val budget: Int,
    val vote_average: Double
) : Parcelable