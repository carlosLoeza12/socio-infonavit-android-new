package com.example.socio_infonavit_android_new.repository

import com.example.socio_infonavit_android_new.data.model.User
import com.example.socio_infonavit_android_new.data.model.member
import retrofit2.http.Body
import retrofit2.http.GET

interface UserService {

    @GET("login")
    suspend fun makeLogin(@Body user: User): member
}