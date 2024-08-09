package com.practicum.mymovies.domain.api

import com.practicum.mymovies.domain.models.Movie
import com.practicum.mymovies.domain.models.MovieDetails
import com.practicum.mymovies.domain.models.Resource

interface MoviesRepository {

    fun searchMovies(expression: String): Resource<List<Movie>>

    fun getMovieDetails(movieId: String): Resource<MovieDetails>

    fun addMovieToFavorites(movie: Movie)

    fun removeMovieFromFavorites(movie: Movie)

}