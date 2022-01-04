package com.example.socio_infonavit_android_new.data.remote

import com.example.socio_infonavit_android_new.data.model.Member
import com.example.socio_infonavit_android_new.data.model.User
import com.example.socio_infonavit_android_new.repository.UserService
import javax.inject.Inject

class UserDataSource @Inject constructor(private val userService: UserService) {

   suspend fun makeLogin(User: User): Member = userService.makeLoginService(User)

}