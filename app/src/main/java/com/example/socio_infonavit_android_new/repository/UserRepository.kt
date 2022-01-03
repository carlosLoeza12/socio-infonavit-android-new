package com.example.socio_infonavit_android_new.repository

import com.example.socio_infonavit_android_new.data.model.User
import com.example.socio_infonavit_android_new.data.model.member

interface UserRepository {

    suspend fun makeLogin(user: User): member
}