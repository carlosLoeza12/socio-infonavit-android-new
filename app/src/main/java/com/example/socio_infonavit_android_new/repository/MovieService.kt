package com.example.socio_infonavit_android_new.repository

import com.example.socio_infonavit_android_new.data.model.MovieList
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MovieService {

    @GET
    suspend fun getMovies(@Url url:String):MovieList

}