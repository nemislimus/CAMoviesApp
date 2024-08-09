package com.practicum.mymovies.ui.poster.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailsFragmentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val posterUrl: String,
    private val movieId: String,
): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> PosterFragment.newInstance(posterUrl = posterUrl)
            else -> AboutFragment.newInstance(movieId = movieId)
        }
    }

}