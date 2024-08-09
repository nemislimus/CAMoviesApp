package com.practicum.mymovies.ui.poster.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.practicum.mymovies.databinding.FragmentAboutBinding
import com.practicum.mymovies.domain.models.MovieDetails
import com.practicum.mymovies.ui.poster.models.MovieDetailsState
import com.practicum.mymovies.ui.poster.view_model.AboutViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AboutFragment: Fragment() {

    private lateinit var binding: FragmentAboutBinding


    private val aboutViewModel by viewModel<AboutViewModel> {
        parametersOf(requireArguments().getString(MOVIE_ID))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Observe liveData from ViewModel
        aboutViewModel.getMovieDetails().observe(viewLifecycleOwner) { detailsState ->
            renderDetailsState(detailsState)
        }
    }

    private fun renderDetailsState(state: MovieDetailsState) {
        when(state) {
            is MovieDetailsState.Details -> {
                binding.infoGroup.isVisible = true
                binding.infoPlaceholder.isVisible = false
                setMovieDetailsValues(state.details)
            }

            is MovieDetailsState.Error -> {
                binding.infoGroup.isVisible = false
                binding.infoPlaceholder.apply {
                    isVisible = true
                    text = state.errorMessage
                }
            }
        }
    }

    private fun setMovieDetailsValues(details: MovieDetails) {
        binding.apply {
            title.text = details.title
            ratingValue.text = details.imDbRating
            yearValue.text = details.year
            countryValue.text = details.countries
            genreValue.text = details.genres
            directorsValue.text = details.directors
            writersValue.text = details.writers
            starsValue.text = details.stars
            plotValue.text = details.plot
        }
    }

    companion object {
        private const val MOVIE_ID = "movie_id"

        fun newInstance(movieId: String) = PosterFragment().apply {
            arguments = bundleOf(MOVIE_ID to movieId)
        }

    }
}