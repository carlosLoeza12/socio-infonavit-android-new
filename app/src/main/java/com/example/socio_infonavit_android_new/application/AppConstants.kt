package com.example.socio_infonavit_android_new.application

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object AppConstants {

    const val BASE_URL_SOCIO = "https://staging.api.socioinfonavit.io/api/v1/"
    const val URL_MOVIE = "https://api.themoviedb.org/3/movie/now_playing?api_key=a28c4bc831b590dc669ef8a459fdbff7&language=es-MX"
    const val BASE_IMAGE_MOVIE = "https://image.tmdb.org/t/p/w500/"

    // Create Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    var okHttp = OkHttpClient.Builder().addInterceptor(logger)
}