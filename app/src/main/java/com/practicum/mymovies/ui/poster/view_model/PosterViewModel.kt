package com.practicum.mymovies.ui.poster.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PosterViewModel (
    private val posterUrl: String
) : ViewModel() {

    private var posterPictUrl = MutableLiveData(posterUrl)
    fun getPosterUrlLiveData(): LiveData<String> = posterPictUrl

}