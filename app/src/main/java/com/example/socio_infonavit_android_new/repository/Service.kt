package com.example.socio_infonavit_android_new.repository

import com.example.socio_infonavit_android_new.data.model.Member
import com.example.socio_infonavit_android_new.data.model.MovieList
import com.example.socio_infonavit_android_new.data.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface Service {

    @POST("login")
    suspend fun makeLoginService(@Body User: User): Member

    @GET
    suspend fun getMovies(@Url url:String): MovieList

}