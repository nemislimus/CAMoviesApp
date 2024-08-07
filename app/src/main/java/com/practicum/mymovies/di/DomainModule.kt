package com.practicum.mymovies.di

import com.practicum.mymovies.data.MoviesRepositoryImpl
import com.practicum.mymovies.domain.api.MoviesInteractor
import com.practicum.mymovies.domain.api.MoviesRepository
import com.practicum.mymovies.domain.impl.MoviesInteractorImpl
import org.koin.dsl.module

val domainModule = module {

    single<MoviesInteractor> {
        MoviesInteractorImpl(
            repository = get()
        )
    }

//    single<SearchHistoryInteractor> {
//        SearchHistoryInteractorImpl()
//    }

    single<MoviesRepository> {
        MoviesRepositoryImpl(
            networkClient = get(),
            localStorage =  get(),
        )
    }

//    single<SearchHistoryRepository> {
//        SearchHistoryRepositoryImpl()
//    }

}