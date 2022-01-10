package com.example.socio_infonavit_android_new.repository

import com.example.socio_infonavit_android_new.data.model.MovieList

interface MovieRepository  {

    suspend fun getMovies(): MovieList

}