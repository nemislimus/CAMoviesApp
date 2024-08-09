package com.practicum.mymovies.ui.poster.models

import com.practicum.mymovies.domain.models.MovieDetails

sealed interface MovieDetailsState {

    data class Details(
        val details: MovieDetails
    ) : MovieDetailsState

    data class Error(
        val errorMessage: String
    ) : MovieDetailsState
}