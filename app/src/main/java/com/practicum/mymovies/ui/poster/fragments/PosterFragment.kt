package com.practicum.mymovies.ui.poster.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.practicum.mymovies.R
import com.practicum.mymovies.databinding.FragmentPosterBinding
import com.practicum.mymovies.ui.poster.view_model.PosterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PosterFragment : Fragment() {

    private lateinit var binding: FragmentPosterBinding

    private val posterViewModel: PosterViewModel by viewModel {
        parametersOf(requireArguments().getString(POSTER_URL))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPosterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Observe liveData from ViewModel
        posterViewModel.getPosterUrlLiveData().observe(viewLifecycleOwner){ url ->
            setupPosterImage(url)
        }
    }

    private fun setupPosterImage(url: String) {
        Glide.with(requireActivity())
            .load(url)
            .placeholder(R.drawable.no_poster)
            .fitCenter()
            .into(binding.poster)
    }

    companion object {
        private const val POSTER_URL = "poster_url"

        fun newInstance(posterUrl: String) = PosterFragment().apply {
            arguments = bundleOf(POSTER_URL to posterUrl)
        }
    }
}