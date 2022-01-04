package com.example.socio_infonavit_android_new.repository

import com.example.socio_infonavit_android_new.data.model.Member
import com.example.socio_infonavit_android_new.data.model.User
import com.example.socio_infonavit_android_new.data.remote.UserDataSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDataSource: UserDataSource): UserRepository {

    override suspend fun makeLogin(User: User): Member = userDataSource.makeLogin(User)

}