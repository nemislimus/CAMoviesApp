package com.practicum.mymovies.di

import com.practicum.mymovies.ui.movies.view_model.MoviesSearchViewModel
import com.practicum.mymovies.ui.poster.view_model.AboutViewModel
import com.practicum.mymovies.ui.poster.view_model.PosterViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        MoviesSearchViewModel(
            moviesInteractor =  get(),
            application =  androidApplication())
    }

    viewModel { (imageUrl: String) ->
        PosterViewModel(posterUrl = imageUrl)
    }

    viewModel {(movieId: String) ->
        AboutViewModel(movieId, get())
    }



}