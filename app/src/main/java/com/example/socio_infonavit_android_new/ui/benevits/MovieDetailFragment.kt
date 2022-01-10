package com.example.socio_infonavit_android_new.ui.benevits

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.socio_infonavit_android_new.R
import com.example.socio_infonavit_android_new.application.AppConstants
import com.example.socio_infonavit_android_new.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private lateinit var binding: FragmentMovieDetailBinding
    private val args by navArgs<MovieDetailFragmentArgs>()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailBinding.bind(view)

        binding.imgMovie.load(AppConstants.BASE_IMAGE_MOVIE+args.posterImageUrl)
        binding.imgBackGround.load(AppConstants.BASE_IMAGE_MOVIE+args.backGroundImageUrl)
        binding.txtOverview.text = args.overView
        binding.txtTitleMovie.text = args.title
        binding.txtLanguage.text =  "${requireContext().getString(R.string.movie_language)} ${args.language}"
        binding.txtRating.text = "${args.voteAverage} (${args.voteCount} ${requireContext().getString(R.string.movie_votes)})"
        binding.txtRelease.text = "${requireContext().getString(R.string.movie_release)} ${args.releaseDate}"
    }

}