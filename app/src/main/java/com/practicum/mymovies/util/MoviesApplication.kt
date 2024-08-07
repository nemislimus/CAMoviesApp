package com.practicum.mymovies.util

import android.app.Application
import com.practicum.mymovies.di.dataModule
import com.practicum.mymovies.di.interactorModule
import com.practicum.mymovies.di.repositoryModule
import com.practicum.mymovies.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/// HERE IS CLONE FROM FORK
class MoviesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MoviesApplication)
            modules(dataModule, repositoryModule, interactorModule, viewModelModule)
        }
    }

}