package com.example.socio_infonavit_android_new.repository

import com.example.socio_infonavit_android_new.data.model.Member
import com.example.socio_infonavit_android_new.data.model.User

interface UserRepository {

    suspend fun makeLogin(User: User): Member
}