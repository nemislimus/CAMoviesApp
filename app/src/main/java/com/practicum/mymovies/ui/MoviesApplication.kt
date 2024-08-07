package com.practicum.mymovies.ui

import android.app.Application
import com.practicum.mymovies.di.dataModule
import com.practicum.mymovies.di.domainModule
import com.practicum.mymovies.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MoviesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MoviesApplication)
            modules(dataModule, domainModule, presentationModule)
        }

    }

}