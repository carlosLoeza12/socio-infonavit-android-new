package com.example.socio_infonavit_android_new.data.remote

import com.example.socio_infonavit_android_new.data.model.Member
import com.example.socio_infonavit_android_new.data.model.User
import com.example.socio_infonavit_android_new.repository.Service
import javax.inject.Inject

class UserDataSource @Inject constructor(private val service: Service) {

   suspend fun makeLogin(User: User): Member = service.makeLoginService(User)

}