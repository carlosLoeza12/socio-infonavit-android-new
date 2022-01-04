package com.example.socio_infonavit_android_new.repository

import com.example.socio_infonavit_android_new.data.model.Member
import com.example.socio_infonavit_android_new.data.model.User
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("login")
    suspend fun makeLoginService(@Body User: User): Member

}