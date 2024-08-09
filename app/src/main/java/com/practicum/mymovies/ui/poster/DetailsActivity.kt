package com.practicum.mymovies.ui.poster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.practicum.mymovies.databinding.ActivityDetailsBinding
import com.practicum.mymovies.ui.poster.fragments.DetailsFragmentAdapter

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    private lateinit var tabMediator: TabLayoutMediator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentPosterUrl = intent.getStringExtra("poster") ?: ""
        val currentMovieId = intent.getStringExtra("movieId") ?: ""

        binding.detailViewPager.adapter = DetailsFragmentAdapter(
            supportFragmentManager,
            lifecycle,
            currentPosterUrl,
            currentMovieId
        )

        tabMediator = TabLayoutMediator(binding.detailTabs, binding.detailViewPager) { tabElement, position ->
            when(position) {
                0 -> tabElement.text = "Poster"
                1 -> tabElement.text = "Details"
            }
        }

        tabMediator.attach()

    }

    override fun onDestroy() {
        super.onDestroy()
        tabMediator.detach()
    }
}