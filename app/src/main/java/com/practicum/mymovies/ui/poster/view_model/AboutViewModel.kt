package com.practicum.mymovies.ui.poster.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.practicum.mymovies.domain.api.MoviesInteractor
import com.practicum.mymovies.domain.models.MovieDetails
import com.practicum.mymovies.ui.poster.models.MovieDetailsState

class AboutViewModel(
    private val movieId: String,
    private val moviesInteractor: MoviesInteractor,
): ViewModel() {

    private var movieDetails = MutableLiveData<MovieDetailsState>()
    fun getMovieDetails(): LiveData<MovieDetailsState> = movieDetails

    init {
        moviesInteractor.getMovieDetails(
            movieId,
            object: MoviesInteractor.MovieDetailsConsumer {
                override fun consume(details: MovieDetails?, message: String?) {
                    if (message == null) {
                        renderDetailsState(
                            state = MovieDetailsState.Details(
                                details = details!!
                            )
                        )
                    } else {
                        renderDetailsState(
                            state = MovieDetailsState.Error(
                                errorMessage = message
                            )
                        )
                    }
                }
            }
        )
    }

    private fun renderDetailsState(state: MovieDetailsState) {
        movieDetails.postValue(state)
    }

}