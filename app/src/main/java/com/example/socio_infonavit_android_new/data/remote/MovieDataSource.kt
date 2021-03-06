package com.example.socio_infonavit_android_new.data.remote

import com.example.socio_infonavit_android_new.application.AppConstants
import com.example.socio_infonavit_android_new.data.model.MovieList
import com.example.socio_infonavit_android_new.repository.Service
import javax.inject.Inject

class MovieDataSource @Inject constructor(private val movieService: Service) {

    suspend fun getMovies(): MovieList = movieService.getMovies(AppConstants.URL_MOVIE)
}