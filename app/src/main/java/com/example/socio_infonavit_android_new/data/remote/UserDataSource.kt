package com.example.socio_infonavit_android_new.data.remote

import com.example.socio_infonavit_android_new.data.model.User
import com.example.socio_infonavit_android_new.data.model.member
import com.example.socio_infonavit_android_new.repository.UserService
import javax.inject.Inject

class UserDataSource @Inject constructor(private val userService: UserService, private val user: User) {
   suspend fun makeLogin(): member = userService.makeLogin(user)
}